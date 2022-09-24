package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class PsloginActivity extends Activity {
	EditText et1,et2;
	ImageButton b1,b2;
    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.pslogin);
	        et1=(EditText) findViewById(R.id.uid);
	        et2=(EditText) findViewById(R.id.pass);
	     
	        b1=(ImageButton) findViewById(R.id.btnlogin);
	        b2=(ImageButton) findViewById(R.id.btnclear);
	     
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	                  db.open();        
	            	long id=0;
	            	String uid,pass;
	            	uid=String.valueOf(et1.getText());
	            	pass=String.valueOf(et2.getText());
	            	//id=db.insertUsers(uid, pass, pass);
	            	 Cursor c = db.getUserInfo(uid.trim());
	               if (c.moveToFirst()) 
	               {
	            	if(pass.equals(c.getString(1))){
	                	 Intent i=new Intent(PsloginActivity.this,ScheduleActivity.class);
	                	 startActivity(i);
	                 }
	            	else
	            	{
	            		Toast.makeText(PsloginActivity.this, "Invalid User...",Toast.LENGTH_LONG).show();
	            		et2.setText("");
	            	}
	               }
	                 else
	                 {       
	                 	Toast.makeText(PsloginActivity.this, "Invalid User...",Toast.LENGTH_LONG).show();
	                 	et2.setText("");
	                 }
	                 	db.close();
	            }
	        }); 

	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	              et1.setText("");
	              et2.setText("");
	              
	            }
	        }); 
	    }}
	


	        
 