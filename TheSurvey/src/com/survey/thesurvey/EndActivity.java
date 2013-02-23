package com.survey.thesurvey;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class EndActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get message from the Intent
		Intent intent = getIntent();
		intent.getStringExtra(LastScreenActivity.EXTRA_MESSAGE);
		
		setContentView(R.layout.activity_end);
		Toast.makeText(this, "Welldone Guys!!! This completes the first Increment of the project.", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end, menu);
		return true;
	}
	
	//called when the user clicks the Exit button
	public void sendMessage(View view){
		Intent intent=new Intent(this, MainActivity.class);
		startActivity(intent);
		System.exit(0);
	}

}
