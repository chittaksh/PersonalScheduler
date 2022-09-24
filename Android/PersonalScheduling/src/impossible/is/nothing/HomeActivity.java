package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class HomeActivity extends Activity {
	 
	 ImageButton b1,b2,b3;
	 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.home);
	        
	        b1=(ImageButton) findViewById(R.id.btnlogin);
	        b2=(ImageButton) findViewById(R.id.btnconfig);
	        b3=(ImageButton) findViewById(R.id.btnclose);
	        
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            
	            public void onClick(View v) 
	            {
	            	
	            	Intent i=new Intent(HomeActivity.this,PsloginActivity.class);
	            	
	                 startActivity(i);
	            }
	        });
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {  
	            	
	            	Intent i=new Intent(HomeActivity.this,ConfigActivity.class);
	            	 startActivity(i);
	            }
	        });
	        b3.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Intent i=new Intent(HomeActivity.this,PersonalSchedulingActivity.class);
	            	startActivity(i);
	            }
	        });

}
}
