package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
 
public class TodoActivity extends Activity {
 
	 ImageButton b1,b2,b3,b4,b5,b6;
	 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.todo);
	        
	        b1=(ImageButton) findViewById(R.id.btntodoadd);
	        b2=(ImageButton) findViewById(R.id.btntodomodify);
	        b3=(ImageButton) findViewById(R.id.btntododelete);
	        b4=(ImageButton) findViewById(R.id.btntodolist);
	        b5=(ImageButton) findViewById(R.id.btntodomenu);
	        b6=(ImageButton) findViewById(R.id.btntodoexit);
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            
	            public void onClick(View v) 
	            {
	            	
	            	Intent i=new Intent(TodoActivity.this,ManageTodoActivity.class);
	            	
	                 startActivity(i);
	            }
	        });
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {  
	            	
	            	Intent i=new Intent(TodoActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "Modify");
	                startActivity(i);
	            }
	        });
	        b3.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(TodoActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "Delete");
	                 startActivity(i);
	            }
	        });
	        b4.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(TodoActivity.this,TodoinfoActivity.class);
	            	i.putExtra("msg", "List");
	                 startActivity(i);
	            }
	        });
	        b5.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(TodoActivity.this,ScheduleActivity.class);
	                 startActivity(i);
	            }
	        });
	        b6.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(TodoActivity.this,PersonalSchedulingActivity.class);
	                 startActivity(i);
	            }
	        });
	 }
}
