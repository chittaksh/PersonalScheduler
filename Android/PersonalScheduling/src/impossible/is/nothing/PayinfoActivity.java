package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle; 
import java.util.ArrayList;
import java.util.Arrays;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
public class PayinfoActivity extends Activity
{
	  ListView paylst ;
	  ImageButton b1;
	  ArrayAdapter<String> listAdapter ;
	    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.paylist);
	        
	        // Find the ListView resource. 
	     paylst = (ListView) findViewById( R.id.paylstview );
	     b1=(ImageButton) findViewById(R.id.paybtnclose);
	         
	        String[] planets = new String[] {};  
	        ArrayList<String> planetList = new ArrayList<String>();
	        planetList.addAll( Arrays.asList(planets) );
	        
	        // Create ArrayAdapter using the planet list.
	        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	        
	        
	        db.open(); 
	        
	        Bundle extras= getIntent().getExtras(); 
            String uid=String.valueOf(extras.getString("uid"));
	        Cursor c = db.getPAYMENT(uid);
	        c.moveToFirst();
	        int i=0;
	       
	        while(i<c.getCount())
	        {
	        	listAdapter.add(c.getInt(3)+"|"+c.getString(0)+" | "+c.getString(1)+" | "+c.getString(2));
	        	c.moveToNext();
	        	i++;
	        }
	        db.close();
	        
	        // Set the ArrayAdapter as the ListView's adapter.
	        paylst.setAdapter( listAdapter );
	       // Bundle extras= getIntent().getExtras();
	        String act=String.valueOf(extras.getString("msg"));
	        if(act.equals("List"))
	        {}
	        else
	        {
	         paylst.setTextFilterEnabled(true);
	    	 paylst.setOnItemClickListener(new OnItemClickListener() {  
	    		 public void onItemClick(AdapterView<?> parent, View view, 
	    				 int position, long id) { 
	    			 // When clicked, show a toast with the TextView text
	    			 Bundle extras= getIntent().getExtras(); 
	    			 String msg=String.valueOf(extras.getString("msg"));
	    			 String uid=String.valueOf(extras.getString("uid"));
	    			
	    			 if(msg.equals("Modify"))
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), ModifyPayActivity.class); 
	    			     myIntent.putExtra("info", String.valueOf(paylst.getItemAtPosition(position)));
	    			     myIntent.putExtra("uid", uid);
	    			   	startActivityForResult(myIntent, 0);
	    			 }
	    			 else
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), DeletePayActivity.class); 
		    			 myIntent.putExtra("info", String.valueOf(paylst.getItemAtPosition(position)));
		    			 myIntent.putExtra("uid",uid);
		    			 startActivityForResult(myIntent, 0); 
	    			 }
	    			
	    		           
	    			 }       }); 
	        }
	    	  b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 Intent i=new Intent(PayinfoActivity.this,PaymentActivity.class);
		            	 Bundle extras= getIntent().getExtras(); 
		                 String uid=String.valueOf(extras.getString("uid"));
		                 i.putExtra("uid", uid);
		                 startActivity(i);
		              
		            }
		        }); 	 
	        
	        
	 }

}
