package impossible.is.nothing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalSchedulingActivity extends Activity {
    /** Called when the activity is first created. */
	Button b1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
b1=(Button) findViewById(R.id.button1);

        
        b1.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {                

            Intent i=new Intent(PersonalSchedulingActivity.this,HomeActivity.class);
            startActivity(i);
            }
        }); 


    
    }
}