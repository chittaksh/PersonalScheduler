package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
 
public class SimpleRowActivity extends Activity
{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.simplerow);
	        Bundle extras= getIntent().getExtras(); 
	       String msg=String.valueOf(extras.getString("msg")); 
	        
	        Toast.makeText(SimpleRowActivity.this, msg,Toast.LENGTH_LONG).show();
	       // Toast.makeText(SimpleRowActivity.this, "Invalid User...",Toast.LENGTH_LONG).show();
	 }

}
