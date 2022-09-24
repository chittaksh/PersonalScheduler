package impossible.is.nothing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PSAdapter 
{
	public static final String KEY_USERID = "userid";
    public static final String KEY_PASS = "pass";
    public static final String KEY_OLDPASS = "oldpass";
    
    public static final String KEY_DATE = "tododate";
    public static final String KEY_TIME = "todotime";
    public static final String KEY_TODO = "todotask";
    
    private static final String DATABASE_NAME = "pschedule4";
    private static final String DATABASE_TABLE = "users";
    private static final String DATABASE_Todo = "todo";
    private static final int DATABASE_VERSION = 1;

    
    
    private static final String DATABASE_CREATE =
        "create table users (userid text primary key , "
        + "pass text not null, oldpass text not null);";
    
    private static final String CREATE_TODO =
            "create table todo (tododate text primary key, "
            + "todotime text not null, todotask text not null);";
    
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
	public static String TAG;

    public PSAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
            db.execSQL(CREATE_TODO);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public PSAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert a title into the database---
    public long insertUsers(String userid, String pass, String oldpass) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERID, userid);
        initialValues.put(KEY_PASS,pass );
        initialValues.put(KEY_OLDPASS, oldpass);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public long inserttodo(String dt,String time, String task) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_DATE, dt);
        initialValues.put(KEY_TIME,time );
        initialValues.put(KEY_TODO, task);
        return db.insert(DATABASE_Todo, null, initialValues);
    }

    //---deletes a particular title---
    public boolean deleteUsers(String uid) 
    {
        return db.delete(DATABASE_TABLE, KEY_USERID + 
        		"='" + uid +"'", null) > 0;
    }

    public boolean deleteTodo(String task) 
    {
        return db.delete(DATABASE_Todo, KEY_TODO + 
        		"='"+task+"'", null) > 0;
    }

    //---retrieves all the titles---
    public Cursor getValues() 
    {
        return db.query(DATABASE_TABLE, new String[] {
        		KEY_USERID, 
        		KEY_PASS,
        		KEY_OLDPASS
        		}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
    public Cursor getTodo() 
    {
        return db.query(DATABASE_Todo, new String[] {
        		KEY_DATE, 
        		KEY_TIME,
        		KEY_TODO
        		}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }

    //---retrieves a particular title---
    public Cursor getUserInfo(String rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_USERID,
                		KEY_PASS, 
                		KEY_OLDPASS
                		}, 
                		KEY_USERID + "='"+rowId+"'", 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getTodoInfo(String dt) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_Todo, new String[] {
                		KEY_DATE,
                		KEY_TIME, 
                		KEY_TODO
                		}, 
                		KEY_DATE + "='"+dt+"'", 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a title---
    public boolean updateUserInfo(String userid, String pass, String oldpass) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_USERID, userid);
        args.put(KEY_PASS, pass);
        args.put(KEY_OLDPASS, oldpass);
        return db.update(DATABASE_TABLE, args, 
                         KEY_USERID + "='" + userid +"'", null) > 0;
    }
	
    public boolean updateTodoInfo(String tododate, String todotime, String todotask) 
    {
        ContentValues args = new ContentValues();
      
        args.put(KEY_TIME, todotime);
        args.put(KEY_TODO, todotask);
        return db.update(DATABASE_Todo, args, 
                         KEY_DATE + "='"+tododate+"'", null) > 0;
    }
	
	
}
