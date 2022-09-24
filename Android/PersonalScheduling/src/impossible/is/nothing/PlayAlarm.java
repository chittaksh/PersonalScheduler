package impossible.is.nothing;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

 
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayAlarm extends Activity{
	 PSAdapter db=new PSAdapter(this);
	MediaPlayer mp;
	TextView t1;
	Button b1;
	public String tbl="",uid="";
	public int id=0;
	final String SOAP_ACTION = "http://tempuri.org/UpdateSchedule";
    final String METHOD_NAME = "UpdateSchedule";
    final String NAMESPACE = "http://tempuri.org/";
    final String URL = "http://10.0.2.2:49247/MyService/MyScheduler.asmx";
    public String res="",date="",tm="";
    private PropertyInfo pi1;
    private PropertyInfo pi2;
    public String tid="";
    Object response;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
	
        try{
            boolean mStartPlaying = true;
           mp=null;
        if (mStartPlaying==true){

        	 mp=MediaPlayer.create(this,R.raw.nokia);
                mp.start();
                mp.setLooping(false);
        } 
        else{
           //   stopPlaying();
            //rePlay.setText("Replay");
            mp.release();
            mp = null;
        }
        mStartPlaying = !mStartPlaying;


        } 
        catch (Exception ex){
        	Toast mToast=Toast.makeText(PlayAlarm.this,"Error :"+ex.getMessage(),Toast.LENGTH_SHORT);
			  mToast.show();
        }
       // mp=MediaPlayer.create(this,R.raw.nokia);
       // mp.start();
        t1=(TextView) findViewById(R.id.task);
	try
	{
        Bundle extras= getIntent().getExtras(); 
        String task=String.valueOf(extras.getString("task")).trim();
         tbl=String.valueOf(extras.getString("name")).trim();
         id=Integer.parseInt(String.valueOf(extras.getString("id")).trim());
        
        		// t1.setText(task);
  			/*String str[]=task.split("\\-");
          	 
          	for(int i=0;i<str.length;i++)
          	{
          		String str1[]=str[i].split("\\|");
          	 t1.setText(t1.getText()+"\n"+str[i]);
          	 for(int j=0;j<str1.length;j=j+2)
          	tid=str1[j]+",";
          	}*/
        	 
        	//	 String str[]=task.split("\\|");
        		// tid=str[0]+",";
        		// t1.setText(task);
        		// Toast mToast=Toast.makeText(PlayAlarm.this,"Error :"+ex.getMessage(),Toast.LENGTH_SHORT);
       		//  mToast.show();
       
        	 
  		  // new backMethod().execute();
  	  
        
          
        // Toast mToast=Toast.makeText(PlayAlarm.this,"ID :"+String.valueOf(extras.getString("id")).trim(),Toast.LENGTH_SHORT);
		//  mToast.show();
      //  String uid=String.valueOf(extras.getString("uid")).trim();
        //Toast.makeText(PlayAlarm.this, "uid"+uid,Toast.LENGTH_LONG).show();
        		// mp.setLooping(false);
       t1.setText("");
       b1=(Button) findViewById(R.id.btnstop);
    //  mp.stop();
       db.open();
	   if(tbl.equals("todo"))
	   {
		   t1.setText(task);
	   if(db.updateTodosts(id, "over"))
	   {
		    
	   }
	   }
	   else if(tbl.equals("payment"))
	   {
		   t1.setText(task);
		   if(db.updatepaysts(id, "over"))
    	   {
    		   
    	   }
	   }
	   else if(tbl.equals("WS"))
	   {
		   try
		   {
			   db.open();
			   Cursor cuid=null;
			   cuid=db.getuid();
			   if(cuid.moveToFirst())
			   {
				   uid=cuid.getString(0);
			   }
			   String str1[]=task.split("\\-");
			   if(str1.length>0)
			   {
				   for(int i=0;i<str1.length;i++)
				   {
					   t1.setText(t1.getText()+"\n"+str1[i]);
					   String str[]=str1[i].split("\\|");
					   if(str.length>0)
					   {
						   tid+=str[0]+",";
					   }
				   }
			   }
			   else
			   {
				   String str[]=task.split("\\|");
				   {
					   if(str.length>0)
					   {
						   tid+=str[0]+",";
					   }
				   }
			   }
		   }
		   catch(Exception ex)
		   {
				Toast mToast=Toast.makeText(PlayAlarm.this,"Error :"+ex.getMessage(),Toast.LENGTH_SHORT);
	       		 mToast.show();
		   }
		 
		   Toast mToast=Toast.makeText(PlayAlarm.this,"ids"+tid,Toast.LENGTH_SHORT);
     		 mToast.show();
		   new backMethod().execute();
	   }
	   
	    
	   else
	   {
		   t1.setText(task);
		   if(db.updatemeetsts(id, "over"))
    	   {
    		   
    	   }
	   }
         
        
	 }
	 catch(Exception ex){
		 Toast mToast=Toast.makeText(PlayAlarm.this,"Error :"+ex.getMessage(),Toast.LENGTH_SHORT);
		  mToast.show();
	 }
       b1.setOnClickListener(new View.OnClickListener() 
       {
           public void onClick(View v) 
           {            
        	   
           	//   PlayAlarm p=new PlayAlarm();
        	   try
        	   {
        	   db.open();
        	   mp.release();
               mp = null;
        	  // mp.stop();
        	   Cursor cuid=null;
        	   cuid=db.getuid();
        	   if(cuid.moveToFirst())
        	   {
        		   uid=cuid.getString(0);
        	   }
           	   Intent i=new Intent(PlayAlarm.this,ScheduleActivity.class);
           	   i.putExtra("uid", uid);
       	       startActivity(i);
        	    
           }
      	 catch(Exception ex){
      		 Toast mToast=Toast.makeText(PlayAlarm.this,"Error :"+ex.getMessage(),Toast.LENGTH_SHORT);
      		  mToast.show();
      	 }
           }
       }); 
	}

	public class backMethod extends AsyncTask<String, Object, Object > {

	    
	    private final ProgressDialog dialog = new ProgressDialog(PlayAlarm.this);    
	                                
	                                   @Override
	                                   protected void onPreExecute() {
	                                
	                                                   this.dialog.setMessage("Checking...");              
	                                                    this.dialog.show();  
	                                   }

	                                   @Override
	                                   protected void onCancelled(Object result) {
	                                                
	                                                   super.onCancelled(result);
	                                   }

	                                   @Override
	                                   protected void onPostExecute(Object result) {
	                                  //Here All your UI part is Done
	                                
	                                                   if (result != null) {
	                                                                   String myOutput=result.toString();
	                                                                   res=myOutput;
	                                                                   Toast.makeText(getApplicationContext(),
	                                                                           "Result Found is ==  " + myOutput + "", Toast.LENGTH_LONG)
	                                                                                                                    .show();
	                                                                 //  setContentView(LoginActivity.this.result);
	                                                
	                                                   } else {
	                                                                   Toast.makeText(getApplicationContext(),
	                                                          "Result Found is ==  " + result + "", Toast.LENGTH_LONG)
	                                                                                                   .show();
	                                                   }
	                                                   super.onPostExecute(result);
	                                                   if (this.dialog.isShowing()) {

	                                                                   this.dialog.dismiss();
	                                                   }
	                                                   super.onPostExecute(result);
	                                   }

	                                
	                                   @Override
	                                   protected Object doInBackground(String... params) {
	                                                                                
	                                   SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	                                   pi1 = new PropertyInfo();
	                                 	 pi1.setName("a");
	                                   	 pi1.setValue(uid.trim());//get the string that is to be sent to the web service
	                                   	 pi1.setType(String.class);
	                                   //	request.addProperty(pi1);
	                                   	 request.addProperty("userid","" +uid.toString().trim());
	                                   	 request.addProperty("tid","" +tid.toString().trim());
	                                    
	                                 //  	pi2 = new PropertyInfo();
	                                   //	 pi2.setName("b");
	                                  	// pi2.setValue(etpass.getText().toString().trim());//get the string that is to be sent to the web service
	                                  	// pi2.setType(String.class);
	                                 //	request.addProperty(pi2);
	                                  
	                                  SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
	                                                                                   SoapEnvelope.VER11);
	                                                   envelope.dotNet = true;
	                                                   envelope.setOutputSoapObject(request);
	                                                   try {

	                                                                   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

	                                                                   androidHttpTransport.call(SOAP_ACTION, envelope);
	                                                                
	                                                                   response = (SoapPrimitive) envelope.getResponse();
	                                                                                //here SoapPrimitive is an important part                                                                                              
	                                                   } catch (Exception e) {
	                                                                   e.printStackTrace();
	                                                   }
	                                                   return response;
	                                   }
	                   }
	   }
