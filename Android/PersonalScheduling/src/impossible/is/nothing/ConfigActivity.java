package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class ConfigActivity extends Activity {
	EditText et1,et2,et3;
	ImageButton b1,b2;
    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.configuration);
	        et1=(EditText) findViewById(R.id.uid);
	        et2=(EditText) findViewById(R.id.pass);
	        et3=(EditText) findViewById(R.id.repass);
	        b1=(ImageButton) findViewById(R.id.btnsave);
	        b2=(ImageButton) findViewById(R.id.btnclose);	
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            { 
	                         
	            	long id=0;
	            	String uid,pass,oldpass;
	            	uid=String.valueOf(et1.getText());
	            	pass=String.valueOf(et2.getText());
	            	oldpass=String.valueOf(et3.getText());
	             if(uid.equals("") || pass.equals("") || oldpass.equals(""))
	            	 Toast.makeText(ConfigActivity.this, "Please enter all specifications!!"+pass,Toast.LENGTH_LONG).show();
	             else
	             {
	             if(et2.getText().toString().trim().equals(et3.getText().toString().trim()))
	       	     {
	            	//id=db.insertUsers(uid, pass, pass);
	            	 db.open();
	            	 Cursor c = db.getUserInfo(uid.trim());
	               if (c.moveToFirst()) 
	               {
	            	   db.updateUserInfo(uid, pass, oldpass);
	            	   Toast.makeText(ConfigActivity.this, "User Updated Successfully...\nUser Id : "+uid+"\nPassword :"+pass,Toast.LENGTH_LONG).show();
	                  // Intent i=new Intent(ConfigActivity.this,ScheduleActivity.class);
	                   //startActivity(i);
	            	   
	               }
	                 else
	                 { 
	                	 id=db.insertUsers(uid.trim(), pass.trim(), pass.trim());
	                	 if(id>0)
	                		 Toast.makeText(ConfigActivity.this, "User Registered Successfully...\nUser Id : "+uid+"\nPassword :"+pass,Toast.LENGTH_LONG).show();
	                	 else
	                		 Toast.makeText(ConfigActivity.this, "User Registration Failed !",Toast.LENGTH_LONG).show();
	                	 
	                 }
	                 	db.close();
	                 	et1.setText("");
	                	 et2.setText("");
	     	   	    	et3.setText("");
	     	   	    	et1.requestFocus();
	       	  }
	   	      else
	   	      {
	   	    	Toast.makeText(ConfigActivity.this, "Passwords Mismatch...",Toast.LENGTH_LONG).show();
	   	    	et2.setText("");
	   	    	et3.setText("");
	   	    	et2.requestFocus();
	   	      }
	             
	             }     
	            }
	        }); 
	      
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(ConfigActivity.this,PersonalSchedulingActivity.class);
	                startActivity(i);
	              
	            }
	        }); 
	    }}
	

