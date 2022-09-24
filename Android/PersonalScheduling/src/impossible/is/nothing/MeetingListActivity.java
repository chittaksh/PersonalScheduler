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
public class MeetingListActivity extends Activity
{
	  ListView meetlst ;
	  ImageButton b1;
	  ArrayAdapter<String> listAdapter ;
	    PSAdapter db=new PSAdapter(this);
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.meetinglist);
	        
	        // Find the ListView resource. 
	     meetlst = (ListView) findViewById( R.id.meetlstview);
	     b1=(ImageButton) findViewById(R.id.meetbtnclose);
	        // Create and populate a List of planet names.
	        String[] planets = new String[] {};  
	        ArrayList<String> planetList = new ArrayList<String>();
	        planetList.addAll( Arrays.asList(planets) );
	        
	        // Create ArrayAdapter using the planet list.
	        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
	        
	        
	        db.open(); 
	        
	        Bundle extras= getIntent().getExtras(); 
            String uid=String.valueOf(extras.getString("uid")).trim();
            
	        Cursor c = db.getMeeting(uid);
	        c.moveToFirst();
	        int i=0;
	      //  Toast.makeText(TodoinfoActivity.this, String.valueOf(c.getCount()),Toast.LENGTH_LONG).show();
	        while(i<c.getCount())
	        {
	        	listAdapter.add(c.getInt(3)+"|"+c.getString(0)+" | "+c.getString(1)+" | "+c.getString(2));
	        	c.moveToNext();
	        	i++;
	        }
	        db.close();
	        
	        // Set the ArrayAdapter as the ListView's adapter.
	        meetlst.setAdapter( listAdapter );
	        //Bundle extras= getIntent().getExtras();
	        String act=String.valueOf(extras.getString("msg"));
	        if(act.equals("List"))
	        {}
	        else
	        {
	         meetlst.setTextFilterEnabled(true);
	    	 meetlst.setOnItemClickListener(new OnItemClickListener() {  
	    		 public void onItemClick(AdapterView<?> parent, View view, 
	    				 int position, long id) { 
	    			 // When clicked, show a toast with the TextView text
	    			 Bundle extras= getIntent().getExtras(); 
	    			 String msg=String.valueOf(extras.getString("msg"));
	    			 String uid=String.valueOf(extras.getString("uid"));
	    			 if(msg.equals("Modify"))
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), ModifyMeetingActivity.class); 
	    			     myIntent.putExtra("info", String.valueOf(meetlst.getItemAtPosition(position)));
	    			     myIntent.putExtra("uid",uid);
	    			   	startActivityForResult(myIntent, 0);
	    			 }
	    			 else
	    			 {
	    				 Intent myIntent = new Intent(view.getContext(), DeleteMeetingActivity.class); 
		    			 myIntent.putExtra("info", String.valueOf(meetlst.getItemAtPosition(position)));
		    			 myIntent.putExtra("uid",uid);
		    			 startActivityForResult(myIntent, 0); 
	    			 }
	    			
	    		           
	    			 }       }); 
	        }
	    	  b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 Intent i=new Intent(MeetingListActivity.this,MeetingActivity.class);
		            	 Bundle extras= getIntent().getExtras(); 
		                 String uid=String.valueOf(extras.getString("uid"));
		                 i.putExtra("uid", uid);
		                 startActivity(i);
		              
		            }
		        }); 	 
	        
	        
	 }

}