package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DeleteTodoActivity extends Activity {
	
	PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et1,et2,et3;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.deletetodo);
	        Bundle extras= getIntent().getExtras(); 
		       String msg=String.valueOf(extras.getString("info"));
		       String info[]=msg.split("\\|");
		      // for(int i = 0; i < info.length; i++) 
		    	//   Toast.makeText(ModifyTodoActivity.this, info[i],Toast.LENGTH_LONG).show();  

		      //  Toast.makeText(DeleteTodoActivity.this, msg,Toast.LENGTH_LONG).show();
		        et1=(EditText) findViewById(R.id.date);
		        et2=(EditText) findViewById(R.id.time);
		        et3=(EditText) findViewById(R.id.todo);
		        b1=(ImageButton) findViewById(R.id.submittodo);
		        b2=(ImageButton) findViewById(R.id.cancel);
		        et1.setText(info[0]);
		        et2.setText(info[1]);
		        et3.setText(info[2]);
		        b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 db.open();        
		             	Boolean id;
		             	String dt,time,task;
		             	dt=String.valueOf(et1.getText()).trim();
		             	time=String.valueOf(et2.getText()).trim();
		             	task=String.valueOf(et3.getText()).trim();
		             	id=db.deleteTodo(task.trim());
		             	et1.setText("");
		             	et2.setText("");
		             	et3.setText("");
		             	et1.requestFocus();
		             	if(id==true)
		             		Toast.makeText(DeleteTodoActivity.this, "Todo Deleted Successfully...",Toast.LENGTH_LONG).show();
		             	else
		             		Toast.makeText(DeleteTodoActivity.this, "Deletion Failed...",Toast.LENGTH_LONG).show();
		             	db.close();
		            }
		            
		        });
		        b2.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 Intent i=new Intent(DeleteTodoActivity.this,TodoActivity.class);
		                 startActivity(i);
		            }
		        });
	 }
}



