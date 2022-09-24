package impossible.is.nothing;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ModifyMeetingActivity extends Activity 
{
	 PSAdapter db=new PSAdapter(this);
	 ImageButton b1,b2;
	 EditText et3;
	 private Spinner spinner1,spinnerdt,spinnermon,spinneryr,spinnerhr,spinnermin;
public int mid=0;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.modifymeeting);
	        Bundle extras= getIntent().getExtras(); 
		       String msg=String.valueOf(extras.getString("info"));
		       String info[]=msg.split("\\|");
		      // for(int i = 0; i < info.length; i++) 
		    	//   Toast.makeText(ModifyTodoActivity.this, info[i],Toast.LENGTH_LONG).show();  

		      //  Toast.makeText(ModifyTodoActivity.this, msg,Toast.LENGTH_LONG).show();
		      
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
		        
		       
		        
		        b1=(ImageButton) findViewById(R.id.submittodo);
		        b2=(ImageButton) findViewById(R.id.cancel);
		        mid=Integer.parseInt(info[0]);
		       
		        String dstr[]=info[1].split("\\/");
		        String tstr[]=info[2].split("\\:");
		        String t1str[]=tstr[1].split("\\ ");
		        try
		        {
		        spinnerdt.setPrompt(dstr[0]);
		        spinnermon.setPrompt(dstr[1]);
		        spinneryr.setPrompt(dstr[2]);
		        spinnerhr.setPrompt(tstr[0]);
		        spinnermin.setPrompt(t1str[0]);
		        spinner1.setPrompt(t1str[1]);
		        int ds=Integer.parseInt(dstr[0].toString().trim())-1;
		       spinnerdt.setSelection(ds);
		       int ds1=Integer.parseInt(dstr[1].toString().trim())-1;
		       spinnermon.setSelection(ds1);
		       Date dt=new Date();
		       int d=dt.getYear()+1900;
		       if(d==Integer.parseInt(dstr[2].toString().trim()))
		       {
		    	   d=0;
		       }
		       else 
		    	   d=Integer.parseInt(dstr[2].toString().trim())-d;
		       spinneryr.setSelection(d);
		       int hr=Integer.parseInt(tstr[0].toString().trim())-1;
		       spinnerhr.setSelection(hr);
		       int min=Integer.parseInt(t1str[0].toString().trim())-1;
		       spinnermin.setSelection(min);
		       int t=0;
		       if(t1str[1].equals("am"))
		    	   t=0;
		       else
		    	   t=1;
		       spinner1.setSelection(t);
		        }
		        catch (Exception e) {
		        	 
				}
		       
		       
		       
		        et3=(EditText) findViewById(R.id.meettask);
		        
		       
		        
		        b1=(ImageButton) findViewById(R.id.modifymeeting);
		        b2=(ImageButton) findViewById(R.id.cancel);
		        mid=Integer.parseInt(info[0]);
		        
		        et3.setText(info[3]);
		        b1.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {                
		            	 db.open();        
		             Boolean id;
		             	String dt,time,task,newtask;
		             	
		             	Bundle extras= getIntent().getExtras(); 
			 		       String msg=String.valueOf(extras.getString("info"));
			 		       String info[]=msg.split("\\|");
			 		       task=String.valueOf(info[2].trim());
		             	
		            	
		             	//Bundle extras= getIntent().getExtras(); 
		                String uid=String.valueOf(extras.getString("uid")).trim();
		             	
		            	dt=spinnerdt.getSelectedItem().toString().trim()+"/"+spinnermon.getSelectedItem().toString().trim()+"/"+spinneryr.getSelectedItem().toString().trim();
			             
		             	time=spinnerhr.getSelectedItem().toString().trim()+":"+spinnermin.getSelectedItem().toString().trim()+" "+spinner1.getSelectedItem().toString().trim();
		             	newtask=String.valueOf(et3.getText()).trim();
		             	id=db.updateMeetingInfo(dt,time,newtask,mid);
		              
		             	et3.setText("");
		             	spinnerdt.requestFocus();
		             	if(id==true)
		             	{
		             		Toast.makeText(ModifyMeetingActivity.this, "Meeting Updated Successfully...",Toast.LENGTH_LONG).show();
		             		Intent i=new Intent(ModifyMeetingActivity.this,MeetingActivity.class);
		             		i.putExtra("uid", uid);
			    			startActivityForResult(i, 0); 
		             	}
		             	else
		             		Toast.makeText(ModifyMeetingActivity.this, "Meeting Updation Failed...",Toast.LENGTH_LONG).show();
		             	
		             	
		                db.close();
		            }
		            
		        });
		        b2.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View v) 
		            {         
		            	Bundle extras= getIntent().getExtras(); 
		                String uid=String.valueOf(extras.getString("uid"));
		                
		            	 Intent i=new Intent(ModifyMeetingActivity.this,MeetingActivity.class);
		                i.putExtra("uid",uid);
		            	 startActivity(i);
		            }
		        });
	 }
	 public void addItemsOnSpinner1() {

			spinner1 = (Spinner) findViewById(R.id.spinner1);
			java.util.ArrayList<String> list = new java.util.ArrayList<String>();
			list.add("am");
			list.add("pm");
			
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner1.setAdapter(dataAdapter);
		}

		public void addListenerOnSpinnerItemSelection(){
			
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		}
		
		//get the selected dropdown list value
		public void addListenerOnButton() {

			spinner1 = (Spinner) findViewById(R.id.spinner1);
			 

		}
		
		 public void addItemsOnSpinnerdt() {

				spinnerdt = (Spinner) findViewById(R.id.spinnerdt);
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
				
				spinnerdt = (Spinner) findViewById(R.id.spinnerdt);
				spinnerdt.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			}
			
			//get the selected dropdown list value
			public void addListenerOnButtondt() {

				spinnerdt = (Spinner) findViewById(R.id.spinnerdt);
				 

			}

			
			 public void addItemsOnSpinnermon() {

					spinnermon = (Spinner) findViewById(R.id.spinnermon);
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
					
					spinnermon = (Spinner) findViewById(R.id.spinnermon);
					spinnermon.setOnItemSelectedListener(new CustomOnItemSelectedListener());
				}
				
				//get the selected dropdown list value
				public void addListenerOnButtonmon() {

					spinnermon = (Spinner) findViewById(R.id.spinnermon);
					 

				}
				
				//year
				
				 public void addItemsOnSpinneryr() {

						spinneryr = (Spinner) findViewById(R.id.spinneryr);
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
						
						spinneryr = (Spinner) findViewById(R.id.spinneryr);
						spinneryr.setOnItemSelectedListener(new CustomOnItemSelectedListener());
					}
					
					//get the selected dropdown list value
					public void addListenerOnButtonyr() {

						spinneryr = (Spinner) findViewById(R.id.spinneryr);
						 

					}
					
					
					//hr
					
					 public void addItemsOnSpinnerhr() {

							spinnerhr = (Spinner) findViewById(R.id.spinnerhr);
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
							
							spinnerhr = (Spinner) findViewById(R.id.spinnerhr);
							spinnerhr.setOnItemSelectedListener(new CustomOnItemSelectedListener());
						}
						
						//get the selected dropdown list value
						public void addListenerOnButtonhr() {

							spinnerhr = (Spinner) findViewById(R.id.spinnerhr);
							 

						}
						
						//min
						
						 public void addItemsOnSpinnermin() {

								spinnermin = (Spinner) findViewById(R.id.spinnermin);
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
								
								spinnermin = (Spinner) findViewById(R.id.spinnermin);
								spinnermin.setOnItemSelectedListener(new CustomOnItemSelectedListener());
							}
							
							//get the selected dropdown list value
							public void addListenerOnButtonmin() {

								spinnermin = (Spinner) findViewById(R.id.spinnermin);
								 

							}
}