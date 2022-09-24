package impossible.is.nothing;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DeletePayActivity extends Activity {
	
	PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et1,et2,et3;
	 public String uid="";
public int pid=0;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.deletepay);
	        Bundle extras= getIntent().getExtras(); 
		       String msg=String.valueOf(extras.getString("info"));
		       uid=String.valueOf(extras.getString("uid"));
		       String info[]=msg.split("\\|");
		      
		        et1=(EditText) findViewById(R.id.date);
		        et2=(EditText) findViewById(R.id.time);
		        et3=(EditText) findViewById(R.id.pay);
		        
		        et1.setClickable(false);
		        et2.setClickable(false);
		        et3.setClickable(false);
		        
		        b1=(ImageButton) findViewById(R.id.submitpay);
		        b2=(ImageButton) findViewById(R.id.cancel);
		        pid=Integer.parseInt(info[0]);
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
		             	
		             	Bundle extras= getIntent().getExtras(); 
		                String uid=String.valueOf(extras.getString("uid"));
		             	
		             	id=db.deletePay(pid);
		             	et1.setText("");
		             	et2.setText("");
		             	et3.setText("");
		             	et1.requestFocus();
		             	if(id==true)
		             	{
		             		Toast.makeText(DeletePayActivity.this, "Payment Deleted Successfully...",Toast.LENGTH_LONG).show();
		             		Intent i=new Intent(DeletePayActivity.this,PaymentActivity.class);
		             		i.putExtra("uid", uid);
			    			startActivityForResult(i, 0); 
		             	}
		             	else
		             		Toast.makeText(DeletePayActivity.this, "Payment Deletion failed...",Toast.LENGTH_LONG).show();
		             	db.close();
		            }
		            
		        });
		        b2.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {  
		            	Bundle extras= getIntent().getExtras(); 
		                String uid=String.valueOf(extras.getString("uid"));
		            	 Intent i=new Intent(DeletePayActivity.this,PaymentActivity.class);
		            	 i.putExtra("uid", uid);
		                 startActivity(i);
		            }
		        });
	 }
}



