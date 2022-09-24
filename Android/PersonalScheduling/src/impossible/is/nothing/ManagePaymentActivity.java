package impossible.is.nothing;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class ManagePaymentActivity extends Activity {
	 PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et3;
	public int pid=0;
	private Spinner spinner1,spinnerdt,spinnermon,spinneryr,spinnerhr,spinnermin;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.managepayment);
	       
	        
	        et3=(EditText) findViewById(R.id.pay);
	        b1=(ImageButton) findViewById(R.id.submitpay);
	        b2=(ImageButton) findViewById(R.id.cancel);
	        
	        
	        
	        addItemsOnSpinner1();
			addListenerOnButton();
			addListenerOnSpinnerItemSelection();
			
			addItemsOnSpinnerdt();
				addListenerOnButtondt();
				addListenerOnSpinnerItemSelectiondt();
				
				
				addItemsOnSpinnermon();
				addListenerOnButtonmon();
				addListenerOnSpinnerItemSelectionmon();
				
				addItemsOnSpinneryr();
				addListenerOnButtonyr();
				addListenerOnSpinnerItemSelectionyr();
				
				addItemsOnSpinnerhr();
				addListenerOnButtonhr();
				addListenerOnSpinnerItemSelectionhr();
				
				
				addItemsOnSpinnermin();
				addListenerOnButtonmin();
				addListenerOnSpinnerItemSelectionmin();
	        
	        b1.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	 db.open();   
	            	 Bundle extras= getIntent().getExtras(); 
	                 String uid=String.valueOf(extras.getString("uid"));
	             	long id=0;
	             	String dt,time,task;
	             	dt=spinnerdt.getSelectedItem().toString().trim()+"/"+spinnermon.getSelectedItem().toString().trim()+"/"+spinneryr.getSelectedItem().toString().trim();
		             
	             	time=spinnerhr.getSelectedItem().toString().trim()+":"+spinnermin.getSelectedItem().toString().trim()+" "+spinner1.getSelectedItem().toString().trim();
	             	task=String.valueOf(et3.getText());
	             	Cursor c=db.getpaymax();
	            	c.moveToFirst();
	            	int maxid=0;
	            	try{
	            	maxid=c.getInt(0);
	            	}
	            	catch(Exception ex)
	            	{
	            		maxid=0;
	            	}
	             	id=db.insertpayment((maxid+1),uid,dt, time, task);
	             	 
	             	et3.setText("");
	            spinnerdt.requestFocus();
	             	if(id>0)
	             	{
	             		Toast.makeText(ManagePaymentActivity.this, "Stored Successfully...",Toast.LENGTH_LONG).show();
	             		Intent i=new Intent(ManagePaymentActivity.this,PaymentActivity.class);
	             		i.putExtra("uid", uid);
		    			startActivityForResult(i, 0); 
	             	}
	             	else
	             		Toast.makeText(ManagePaymentActivity.this, "Insertion Failed ",Toast.LENGTH_LONG).show();
	             	db.close();
	            }
	            
	        });
	        b2.setOnClickListener(new View.OnClickListener() 
	        {
	            public void onClick(View v) 
	            {                
	            	Bundle extras= getIntent().getExtras(); 
	                String uid=String.valueOf(extras.getString("uid"));
	              
	            	 Intent i=new Intent(ManagePaymentActivity.this,PaymentActivity.class);
	            	 i.putExtra("uid", uid);
	                 startActivity(i);
	            }
	        });
	 }
	 public void addItemsOnSpinner1() {

			spinner1 = (Spinner) findViewById(R.id.spinnerp1);
			java.util.ArrayList<String> list = new java.util.ArrayList<String>();
			list.add("am");
			list.add("pm");
			
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner1.setAdapter(dataAdapter);
		}

		public void addListenerOnSpinnerItemSelection(){
			
			spinner1 = (Spinner) findViewById(R.id.spinnerp1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		}
		
		//get the selected dropdown list value
		public void addListenerOnButton() {

			spinner1 = (Spinner) findViewById(R.id.spinnerp1);
			 

		}
		
		 public void addItemsOnSpinnerdt() {

				spinnerdt = (Spinner) findViewById(R.id.spinnerpdt);
				java.util.ArrayList<String> list = new java.util.ArrayList<String>();
				for(int i=1;i<=31;i++)
				{
				list.add(String.valueOf(i));
				 
				}
				
				ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
				dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerdt.setAdapter(dataAdapter);
			}

			public void addListenerOnSpinnerItemSelectiondt(){
				
				spinnerdt = (Spinner) findViewById(R.id.spinnerpdt);
				spinnerdt.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			}
			
			//get the selected dropdown list value
			public void addListenerOnButtondt() {

				spinnerdt = (Spinner) findViewById(R.id.spinnerpdt);
				 

			}

			
			 public void addItemsOnSpinnermon() {

					spinnermon = (Spinner) findViewById(R.id.spinnerpmon);
					java.util.ArrayList<String> list = new java.util.ArrayList<String>();
					for(int i=1;i<=12;i++)
					{
					list.add(String.valueOf(i));
					 
					}
					
					ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
					dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					spinnermon.setAdapter(dataAdapter);
				}

				public void addListenerOnSpinnerItemSelectionmon(){
					
					spinnermon = (Spinner) findViewById(R.id.spinnerpmon);
					spinnermon.setOnItemSelectedListener(new CustomOnItemSelectedListener());
				}
				
				//get the selected dropdown list value
				public void addListenerOnButtonmon() {

					spinnermon = (Spinner) findViewById(R.id.spinnerpmon);
					 

				}
				
				//year
				
				 public void addItemsOnSpinneryr() {

						spinneryr = (Spinner) findViewById(R.id.spinnerpyr);
						java.util.ArrayList<String> list = new java.util.ArrayList<String>();
						Date dt=new Date();
						int n=dt.getYear()+1900;
						for(int i=n;i<=n+5;i++)
					{
						list.add(String.valueOf(i));
						 
					}
						
						ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
						dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						spinneryr.setAdapter(dataAdapter);
					}

					public void addListenerOnSpinnerItemSelectionyr(){
						
						spinneryr = (Spinner) findViewById(R.id.spinnerpyr);
						spinneryr.setOnItemSelectedListener(new CustomOnItemSelectedListener());
					}
					
					//get the selected dropdown list value
					public void addListenerOnButtonyr() {

						spinneryr = (Spinner) findViewById(R.id.spinnerpyr);
						 

					}
					
					
					//hr
					
					 public void addItemsOnSpinnerhr() {

							spinnerhr = (Spinner) findViewById(R.id.spinnerphr);
							java.util.ArrayList<String> list = new java.util.ArrayList<String>();
							for(int i=1;i<=12;i++)
							{
							list.add(String.valueOf(i));
							 
							}
							
							ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
							dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							spinnerhr.setAdapter(dataAdapter);
						}

						public void addListenerOnSpinnerItemSelectionhr(){
							
							spinnerhr = (Spinner) findViewById(R.id.spinnerphr);
							spinnerhr.setOnItemSelectedListener(new CustomOnItemSelectedListener());
						}
						
						//get the selected dropdown list value
						public void addListenerOnButtonhr() {

							spinnerhr = (Spinner) findViewById(R.id.spinnerphr);
							 

						}
						
						//min
						
						 public void addItemsOnSpinnermin() {

								spinnermin = (Spinner) findViewById(R.id.spinnerpmin);
								java.util.ArrayList<String> list = new java.util.ArrayList<String>();
								for(int i=1;i<=59;i++)
								{
								list.add(String.valueOf(i));
								 
								}
								
								ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
								dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
								spinnermin.setAdapter(dataAdapter);
							}

							public void addListenerOnSpinnerItemSelectionmin(){
								
								spinnermin = (Spinner) findViewById(R.id.spinnerpmin);
								spinnermin.setOnItemSelectedListener(new CustomOnItemSelectedListener());
							}
							
							//get the selected dropdown list value
							public void addListenerOnButtonmin() {

								spinnermin = (Spinner) findViewById(R.id.spinnerpmin);
								 

							}

	
}
