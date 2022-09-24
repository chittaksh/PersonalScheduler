package impossible.is.nothing;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DeleteMeetingActivity extends Activity {
	
	PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et1,et2,et3;
	 
	 public String uid="";
	 public int mid=0;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.meetingdelete);
	        Bundle extras= getIntent().getExtras(); 
		       String msg=String.valueOf(extras.getString("info"));
		       uid=String.valueOf(extras.getString("uid"));
		       String info[]=msg.split("\\|");
		      // for(int i = 0; i < info.length; i++) 
		    	//   Toast.makeText(ModifyTodoActivity.this, info[i],Toast.LENGTH_LONG).show();  

		      //  Toast.makeText(DeleteTodoActivity.this, msg,Toast.LENGTH_LONG).show();
		        et1=(EditText) findViewById(R.id.date);
		        et2=(EditText) findViewById(R.id.time);
		        et3=(EditText) findViewById(R.id.meettask);
		        
		        et1.setClickable(false);
		        et2.setClickable(false);
		        et3.setClickable(false);
		        
		        b1=(ImageButton) findViewById(R.id.meetdelbtn);
		        b2=(ImageButton) findViewById(R.id.cancel);
		        mid=Integer.parseInt(info[0]);
		        et1.setText(info[1]);
		        et2.setText(info[2]);
		        et3.setText(info[3]);
		        b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 db.open();        
		             	Boolean id;
		             	String dt,time,task;
		             	dt=String.valueOf(et1.getText()).trim();
		             	time=String.valueOf(et2.getText());
		             	task=String.valueOf(et3.getText()).trim();
		             	id=db.deleteMeeting(mid);
		             	et1.setText("");
		             	et2.setText("");
		             	et3.setText("");
		             	et1.requestFocus();
		             	if(id==true)
		             	{
		             		Toast.makeText(DeleteMeetingActivity.this, "Meeting Deleted Successfully...",Toast.LENGTH_LONG).show();
		             		Intent i=new Intent(DeleteMeetingActivity.this,MeetingActivity.class);
		             		i.putExtra("uid", uid);
			    			startActivityForResult(i, 0); 
		             	}
		             	else
		             		Toast.makeText(DeleteMeetingActivity.this, "Deletion Failed...",Toast.LENGTH_LONG).show();
		             	db.close();
		            }
		            
		        });
		        b2.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {      
		            	Bundle extras= getIntent().getExtras(); 
		                String uid=String.valueOf(extras.getString("uid"));
		            	 Intent i=new Intent(DeleteMeetingActivity.this,MeetingActivity.class);
		            	 i.putExtra("uid", uid);
		                 startActivity(i);
		            }
		        });
	 }
}



