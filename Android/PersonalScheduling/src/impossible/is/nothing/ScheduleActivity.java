package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;


public class ScheduleActivity extends Activity {
	ImageButton b1,b2,b3;
    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.schedule);
	        b1=(ImageButton) findViewById(R.id.btntodo);
	        b2=(ImageButton) findViewById(R.id.btnmeet);
	        b3=(ImageButton) findViewById(R.id.btnpay);
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(ScheduleActivity.this,TodoActivity.class);
	                 startActivity(i);
	            }
	        }); 
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(ScheduleActivity.this,MeetingActivity.class);
	                 startActivity(i);
	            }
	        }); 
	        b3.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(ScheduleActivity.this,PaymentActivity.class);
	                 startActivity(i);
	            }
	        }); 
	        
	 }
	

}
