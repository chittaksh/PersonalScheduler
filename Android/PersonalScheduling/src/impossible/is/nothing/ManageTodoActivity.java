package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class ManageTodoActivity extends Activity {
	 PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et1,et2,et3;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.managetodo);
	       // Bundle extras= getIntent().getExtras(); 
	      //  msg=String.valueOf(extras.getString("msg")); 
	        
	      //  Toast.makeText(ManageTodoActivity.this, msg,Toast.LENGTH_LONG).show();
	        et1=(EditText) findViewById(R.id.date);
	        et2=(EditText) findViewById(R.id.time);
	        et3=(EditText) findViewById(R.id.todo);
	        b1=(ImageButton) findViewById(R.id.submittodo);
	        b2=(ImageButton) findViewById(R.id.cancel);
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	 db.open();        
	             	long id=0;
	             	String dt,time,task;
	             	dt=String.valueOf(et1.getText()).trim();
	             	time=String.valueOf(et2.getText()).trim();
	             	task=String.valueOf(et3.getText()).trim();
	             	id=db.inserttodo(dt, time, task);
	             	et1.setText("");
	             	et2.setText("");
	             	et3.setText("");
	             	et1.requestFocus();
	             	if(id>0)
	             		Toast.makeText(ManageTodoActivity.this, "Stored Successfully...",Toast.LENGTH_LONG).show();
	             	else
	             		Toast.makeText(ManageTodoActivity.this, "Insertion Failed ",Toast.LENGTH_LONG).show();
	             	db.close();
	            }
	            
	        });
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	 Intent i=new Intent(ManageTodoActivity.this,TodoActivity.class);
	                 startActivity(i);
	            }
	        });
	 }

	
}
