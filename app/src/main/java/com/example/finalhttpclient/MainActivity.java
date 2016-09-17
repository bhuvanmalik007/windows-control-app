package com.example.finalhttpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


 
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
 
public class MainActivity extends Activity {
	//SharedPreferences pref = getPreferences(MODE_PRIVATE);
	//int x=pref.getInt("N", 0);
	
    ImageButton i1,i2,i3,i4;
    Button b1;
    
    TextView tvIsConnected;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        
        i1=(ImageButton) findViewById(R.id.imageButton1);
        i2=(ImageButton) findViewById(R.id.imageButton2);
        i3=(ImageButton) findViewById(R.id.imageButton3);
        i4=(ImageButton) findViewById(R.id.imageButton4);
        b1=(Button) findViewById(R.id.button1);
 
        // get reference to the views
        
        
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		Editor editor = pref.edit();
		//SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 2);
	      //int x= pref.getInt("log", 0);
	        //Toast.makeText(this, "log  : "+x, Toast.LENGTH_SHORT).show();
		final String email=pref.getString("email", "d");
		final String pwd=pref.getString("pwd", "d");
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String message = "Exit";
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m="+message+","+email+","+pwd);
				Toast.makeText(getBaseContext(), "message sent to cloud!", Toast.LENGTH_LONG).show();
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m=default");
				
			}
		});
        
        i1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String message = "Shutdown";
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m="+message+","+email+","+pwd);
				Toast.makeText(getBaseContext(), "message sent to cloud!", Toast.LENGTH_LONG).show();
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m=default");
				//makeGetRequest(name);
			}
		});
        
        i2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String message = "Restart";
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m="+message+","+email+","+pwd);
				Toast.makeText(getBaseContext(), "message sent to cloud!", Toast.LENGTH_LONG).show();
				
				new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m=default");
				//makeGetRequest(name);
			}
		});


        i3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String message = "Sleep";
		
		new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m="+message+","+email+","+pwd);
		Toast.makeText(getBaseContext(), "message sent to cloud!", Toast.LENGTH_LONG).show();
		
		new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m=default");
		//makeGetRequest(name);
	}
});


        i4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String message = "Lock";
		
		new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m="+message+","+email+","+pwd);
		Toast.makeText(getBaseContext(), "message sent to cloud!", Toast.LENGTH_LONG).show();
		
		new HttpAsyncTask().execute("https://quiet-anchorage-8847.herokuapp.com/demo/first?m=default");
		//makeGetRequest(name);
	}
});
        

 
        // check if you are connected or not
        if(isConnected()){
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are connected");
        }
        else{
            tvIsConnected.setText("You are NOT conncted");
        }
 
        // show response on the EditText etResponse 
        //etResponse.setText(GET("http://hmkcode.com/examples/index.php"));
 
        // call AsynTask to perform network operation on separate thread

    }
 
    public static String GET(String url){
        //InputStream inputStream = null;
        //String result = "";
        try {
 
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
 
            // receive response as inputStream
      /*      inputStream = httpResponse.getEntity().getContent();
 
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";  */
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
           return null;
       // return result;
    }
 
   /* private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }  */
 
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) 
                return true;
            else
                return false;   
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
      /*  @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            etResponse.setText(Html.fromHtml(result));
       }   */
    }
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:

			Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
			Intent i = new Intent("android.intent.action.a");
			startActivity(i);
			break;
			
		case R.id.item2:

			Toast.makeText(this, "Logging Out..", Toast.LENGTH_SHORT).show();
			SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
	        Editor editor = pref.edit();
			 editor.putInt("log",0);
			    editor.commit();
			Intent e = new Intent(MainActivity.this,LoginActivity.class);
			startActivity(e);
			break;

			 
		}
		return super.onMenuItemSelected(featureId, item);
	}
    

 
}