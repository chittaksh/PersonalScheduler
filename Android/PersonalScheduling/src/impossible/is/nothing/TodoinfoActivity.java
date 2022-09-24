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
public class TodoinfoActivity extends Activity
{
	  ListView todolst ;
	  ImageButton b1;
	  ArrayAdapter<String> listAdapter ;
	    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.todoinfo);
	        
	        // Find the ListView resource. 
	     todolst = (ListView) findViewById( R.id.todolstview );
	     b1=(ImageButton) findViewById(R.id.todobtnclose);
	        // Create and populate a List of planet names.
	        String[] planets = new String[] {};  
	        ArrayList<String> planetList = new ArrayList<String>();
	        planetList.addAll( Arrays.asList(planets) );
	        
	        // Create ArrayAdapter using the planet list.
	        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	        
	        
	        db.open(); 
	        Cursor c = db.getTodo();
	        c.moveToFirst();
	        int i=0;
	      //  Toast.makeText(TodoinfoActivity.this, String.valueOf(c.getCount()),Toast.LENGTH_LONG).show();
	        while(i<c.getCount())
	        {
	        	listAdapter.add(c.getString(0)+" | "+c.getString(1)+" | "+c.getString(2));
	        	c.moveToNext();
	        	i++;
	        }
	        db.close();
	        
	        // Set the ArrayAdapter as the ListView's adapter.
	        todolst.setAdapter( listAdapter );
	        Bundle extras= getIntent().getExtras();
	        String act=String.valueOf(extras.getString("msg"));
	        if(act.equals("List"))
	        {}
	        else
	        {
	         todolst.setTextFilterEnabled(true);
	    	 todolst.setOnItemClickListener(new OnItemClickListener() {  
	    		 public void onItemClick(AdapterView<?> parent, View view, 
	    				 int position, long id) { 
	    			 // When clicked, show a toast with the TextView text
	    			 Bundle extras= getIntent().getExtras(); 
	    			 String msg=String.valueOf(extras.getString("msg"));
	    			
	    			 if(msg.equals("Modify"))
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), ModifyTodoActivity.class); 
	    			     myIntent.putExtra("info", String.valueOf(todolst.getItemAtPosition(position)));
	    			   	startActivityForResult(myIntent, 0);
	    			 }
	    			 else
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), DeleteTodoActivity.class); 
		    			 myIntent.putExtra("info", String.valueOf(todolst.getItemAtPosition(position)));
		    			 startActivityForResult(myIntent, 0); 
	    			 }
	    			
	    		           
	    			 }       }); 
	        }
	    	  b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 Intent i=new Intent(TodoinfoActivity.this,TodoActivity.class);
		                 startActivity(i);
		              
		            }
		        }); 	 
	        
	        
	 }

}
