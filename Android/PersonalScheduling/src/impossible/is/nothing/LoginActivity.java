package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
public class LoginActivity extends Activity {

	EditText et1,et2;
	Button b1,b2;
  //  PSAdapter db=new PSAdapter(this);
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        et1=(EditText) findViewById(R.id.uid);
        et2=(EditText) findViewById(R.id.pass);
     
        b1=(Button) findViewById(R.id.btnlogin);
        b2=(Button) findViewById(R.id.btnclear);
     
        b1.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {                
                /*  db.open();        
            	long id=0;
            	String uid,pass;
            	uid=String.valueOf(et1.getText());
            	pass=String.valueOf(et2.getText());
            	 Cursor c = db.getUserInfo(uid);
                 if (c.moveToFirst()) 
                 {
                	// Intent i=new Intent(LoginActivity.this,SimpleOptionMenu.class);
                // startActivity(i);
                 }
                 else
                 {
                 	id = db.insertUsers(uid,pass,pass);        
                 	Toast.makeText(LoginActivity.this, "Stored successfully",Toast.LENGTH_LONG).show();
                 }
                 	db.close();*/
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
    }
}


        


