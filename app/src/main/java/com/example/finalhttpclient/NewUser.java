package com.example.finalhttpclient;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUser extends Activity {
	String mEmail;
	String mPassword;

	// UI references.
	EditText mEmailView;
	EditText mPasswordView;
	Button ss;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_user);
		
		mEmailView = (EditText) findViewById(R.id.email);
		mPasswordView = (EditText) findViewById(R.id.password);
		//ss=(Button) findViewById(R.id.ss);
		
		ss.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				mEmail = mEmailView.getText().toString();
				mPassword = mPasswordView.getText().toString();
			
				
			}
		});
		
	}


}
