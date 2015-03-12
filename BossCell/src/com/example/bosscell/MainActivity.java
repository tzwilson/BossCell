package com.example.bosscell;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



public class MainActivity extends ActionBarActivity {
	public static final String ACCOUNT_SID = "AC56e7fa83ed6f920cb2f553c9c4b3ccf1";
	public static final String AUTH_TOKEN = "4dbe81cd221e9a212e194520aae5a792";
	private void setCarMode(boolean on) {
		UiModeManager umm = (UiModeManager) this.getSystemService(Context.UI_MODE_SERVICE);
		if (on) { 
			umm.enableCarMode(0);
		}
		else {
			umm.disableCarMode(UiModeManager.DISABLE_CAR_MODE_GO_HOME);
		}
	}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    public void handleClick(View v) throws Exception{
    	final TextView text1 = (TextView)findViewById(R.id.textView2);
    	int numberlen = text1.length();
    	if(v.getId() == R.id.button1){
    		if(text1.length() == 0){
    			//text1.setText("*");
    			Intent intent = new Intent(this,Second.class);
    			startActivity(intent);
    		}
    		else{
    		text1.append("*");
    		}
    	}
    	if(v.getId() == R.id.button2)
    	{
    		if(text1.length() == 0){
    			text1.setText("0");
    		}
    		else{
    		text1.append("0");
    		}
    	}
    	if(v.getId() == R.id.button3){
    		if(text1.length() == 0){
    			text1.setText("#");
    		}
    		else{
    		text1.append("#");
    		}
    	}
    	if(v.getId() == R.id.button4){
    		if(text1.length() == 0){
    			text1.setText("7");
    		}
    		else{
    		text1.append("7");
    		}
    	}
    	if(v.getId() == R.id.button5){
    		if(text1.length() == 0){
    			text1.setText("8");
    		}
    		else{
    		text1.append("8");
    		}
    	}
    	if(v.getId() == R.id.button6){
    		if(text1.length() == 0){
    			text1.setText("9");
    		}
    		else{
    		text1.append("9");
    		}
    	}
    	if(v.getId() == R.id.button7){
    		if(text1.length() == 0){
    			text1.setText("4");
    		}
    		else{
    		text1.append("4");
    		}
    	}
    	if(v.getId() == R.id.button8){
    		if(text1.length() == 0){
    			text1.setText("5");
    		}
    		else{
    		text1.append("5");
    		}
    	}
    	if(v.getId() == R.id.button9){
    		if(text1.length() == 0){
    			text1.setText("6");
    		}
    		else{
    		text1.append("6");
    		}
    	}
    	if(v.getId() == R.id.button10){
    		if(text1.length() == 0){
    			text1.setText("1");
    		}
    		else{
    		text1.append("1");
    		}
    	}
    	if(v.getId() == R.id.button11){
    		if(text1.length() == 0){
    			text1.setText("2");
    		}
    		else{
    		text1.append("2");
    		}
    	}
    	if(v.getId() == R.id.button12){
    		if(text1.length() == 0){
    			text1.setText("3");
    		}
    		else{
    		text1.append("3");
    		}
    	}
    	if(numberlen == 10){
    		final String number = text1.getText().toString().substring(0, 10);
			text1.setText("");
    	new Thread(new Runnable(){
			@Override
			public void run() {
			    try {
			    	String url = "http://www.xksdev.net/twilio/notification.php?num="+number;
			    	HttpClient client = new DefaultHttpClient();

			    	try {
			    	  client.execute(new HttpGet(url));
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
    @Override
    public void onResume(){
        super.onResume();
        setCarMode(true); // Enable car mode
		// Work around an Android 2.3 bug that sometimes causes us to become
        // invisible after turning the display off and on with the power button.
        setVisible(false);
        setVisible(true);
    }
    @Override
    protected void onUserLeaveHint(){
    	
    }
    public void exit_car_mode(View view) {
    	setCarMode(false); // Disable car mode and go to Home screen
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
