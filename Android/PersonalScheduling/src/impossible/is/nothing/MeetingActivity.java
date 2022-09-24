package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
public class MeetingActivity extends Activity {
	 
	 ImageButton b1,b2,b3,b4,b5,b6;
	 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.meeting);
	        
	        b1=(ImageButton) findViewById(R.id.meetadd);
	        b2=(ImageButton) findViewById(R.id.meetmodify);
	        b3=(ImageButton) findViewById(R.id.meetdelete);
	        b4=(ImageButton) findViewById(R.id.meetlist);
	        b5=(ImageButton) findViewById(R.id.meetmenu);
	        b6=(ImageButton) findViewById(R.id.meetexit);
	      /*  b1.setOnClickListener(new View.OnClickListener() 
	        {
	            
	            public void onClick(View v) 
	            {
	            	
	            	Intent i=new Intent(MeetingActivity.this,ManageMeetingActivity.class);
	            	
	                 startActivity(i);
	            }
	        });
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {  
	            	
	            	Intent i=new Intent(MeetingActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "Modify");
	                startActivity(i);
	            }
	        });
	        b3.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(MeetingActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "Delete");
	                 startActivity(i);
	            }
	        });
	        b4.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(MeetingActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "List");
	                 startActivity(i);
	            }
	        });*/
	        b5.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(MeetingActivity.this,ScheduleActivity.class);
	                 startActivity(i);
	            }
	        });
	        b6.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(MeetingActivity.this,PersonalSchedulingActivity.class);
	                 startActivity(i);
	            }
	        });
	 }
}
