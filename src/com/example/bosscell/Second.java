package com.example.bosscell;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;

public class Second extends Activity {
	public static final String ACCOUNT_SID = "AC56e7fa83ed6f920cb2f553c9c4b3ccf1";
	public static final String AUTH_TOKEN = "4dbe81cd221e9a212e194520aae5a792";
    CheckBox checkBox = null;
    CheckBox checkBox2 = null;
    CheckBox checkBox3 = null;
    CheckBox checkBox4 = null;
    CheckBox checkBox5 = null;
    CheckBox checkBox6 = null;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	   // checkBox = (CheckBox) findViewById(R.id.checkBox2); //Instagram
	   // checkBox2 = (CheckBox) findViewById(R.id.checkBox1); //Facebook
	   // checkBox3 = (CheckBox) findViewById(R.id.checkBox3); // Google Plus
	   // checkBox4 = (CheckBox) findViewById(R.id.checkBox4); // Linked in
	   // checkBox5 = (CheckBox) findViewById(R.id.checkBox5); // Twitter
	   // checkBox6 = (CheckBox) findViewById(R.id.checkBox6); // Boss Cell
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    //this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.secondlayout);
	    // TODO Auto-generated method stub
	}
	
	public void handleClick(View v){
	    checkBox = (CheckBox) findViewById(R.id.checkBox2); //Instagram
	    checkBox2 = (CheckBox) findViewById(R.id.checkBox1); //Facebook
	    checkBox3 = (CheckBox) findViewById(R.id.checkBox3); // Google Plus
	    checkBox4 = (CheckBox) findViewById(R.id.checkBox4); // Linked in
	    checkBox5 = (CheckBox) findViewById(R.id.checkBox5); // Twitter
	    checkBox6 = (CheckBox) findViewById(R.id.checkBox6); // Boss Cell
		if(v.getId() == R.id.checkBox1){
			checkBox2.setChecked(true);
		}
		if(v.getId() == R.id.checkBox2){
			checkBox.setChecked(true);
		}
		if(v.getId() == R.id.checkBox3){
			checkBox3.setChecked(true);
		}
		if(v.getId() == R.id.checkBox4){
			checkBox4.setChecked(true);
		}
		if(v.getId() == R.id.checkBox5){
			checkBox5.setChecked(true);
		}
		if(v.getId() == R.id.checkBox6){
			checkBox6.setChecked(true);
		}
		if(v.getId() == R.id.button3){
			finish();
		}
		if(v.getId() == R.id.button1){
	    	new Thread(new Runnable(){
				@Override
				public void run() {
				    try {
				        
				    	Bundle extra = getIntent().getExtras();
				    	String num = extra.getString("number");
				    	String insta = "";
				    	String face = "";
				    	String google = "";
				    	String linked = "";
				    	String twit = "";
				    	String boss = "";
				    	
				    	if(checkBox.isChecked()){insta = "instagram";}
				    	if(checkBox2.isChecked()){face = "facebook";}
				    	if(checkBox3.isChecked()){google = "google";}
				    	if(checkBox4.isChecked()){linked = "linkedin";}
				    	if(checkBox5.isChecked()){twit = "twitter";}
				    	if(checkBox6.isChecked()){boss = "bosscell";}
				    	
				    	String url = "http://www.boss-cellular.com/twilio/notification.php?num="+num+"&insta="+insta+"&face="+face+"&google="+google+"&linked="+linked+"&twit="+twit+"&boss="+boss;
				    	HttpClient client = new DefaultHttpClient();

				    	try {
				    	  client.execute(new HttpGet(url));
				    	  finish();
				    	} catch(IOException e) {
				    	  //do something here
				    	}
				    } catch (Exception e) {
				        Log.e("log_tag", "Error in http connection" + e.toString());
				    }
				}
	    		
	    	}).start();
		}
		if(v.getId() == R.id.button2){
	    	new Thread(new Runnable(){
				@Override
				public void run() {
				    try {
				        
				    	Bundle extra = getIntent().getExtras();
				    	String num = extra.getString("number");
				    	String insta = "instagram";
				    	String face = "facebook";
				    	String google = "google";
				    	String linked = "linkedin";
				    	String twit = "twitter";
				    	String boss = "bosscell";
				    	
				    	
				    	String url = "http://www.boss-cellular.com/twilio/notification.php?num="+num+"&insta="+insta+"&face="+face+"&google="+google+"&linked="+linked+"&twit="+twit+"&boss="+boss;
				    	HttpClient client = new DefaultHttpClient();

				    	try {
				    	  client.execute(new HttpGet(url));
				    	  finish();
				    	} catch(IOException e) {
				    	  //do something here
				    	}
				    } catch (Exception e) {
				        Log.e("log_tag", "Error in http connection" + e.toString());
				    }
				}
	    		
	    	}).start();
		}
	}
	

}
