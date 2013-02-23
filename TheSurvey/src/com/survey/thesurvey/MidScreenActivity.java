package com.survey.thesurvey;

import com.survey.thesurvey.NextScreenActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MidScreenActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.survey.thesurvey.MESSAGE";
	private RadioGroup rButtonGroup;
	private int selectedRadioId;
	private int id;
    private int flag = 0;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get message from the Intent
		Intent intent = getIntent();
		intent.getStringExtra(NextScreenActivity.EXTRA_MESSAGE);
		if(savedInstanceState != null ){
			if( flag !=0){
			id = savedInstanceState.getInt("rbutton");
			RadioButton radioButton = (RadioButton) findViewById(id);
			radioButton.setChecked(true);
			}
		}
		
		setContentView(R.layout.activity_mid_screen);
	}
	
	
		
	public void onSaveInstanceState(Bundle savedInstanceState) {

		savedInstanceState.putInt("rbutton", id);
		  super.onSaveInstanceState(savedInstanceState);
		}

	public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Always call the superclass so it can restore the view hierarchy
	    super.onRestoreInstanceState(savedInstanceState);
	    // Restore state members from saved instance
	    id = savedInstanceState.getInt("rbutton");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mid_screen, menu);
		return true;
	}
	
	//called when the user clicks the Next button
	public void sendMessage(View view){
		//perform action
		if(flag==0){
			flag=1;
			rButtonGroup = (RadioGroup) findViewById(R.id.rbg_mid_screen);
			if(rButtonGroup.getCheckedRadioButtonId()!=-1){
			    id= rButtonGroup.getCheckedRadioButtonId();
			    View radioButton = rButtonGroup.findViewById(id);
			    setSelectedRadioId(rButtonGroup.indexOfChild(radioButton));
			}
			Intent intent = new Intent(this, LastScreenActivity.class);
			startActivity(intent);
			
			}
			else{
				//flag=0;
				Intent intent = new Intent(this, LastScreenActivity.class);
				startActivity(intent);
			}
		
	}
	
	//called when the user clicks the previous button
	public void sendMessageBack(View view){
		//perform action
		Intent intent = new Intent(this, NextScreenActivity.class);
		startActivity(intent);
	}

	public int getSelectedRadioId() {
		return selectedRadioId;
	}

	public void setSelectedRadioId(int selectedRadioId) {
		this.selectedRadioId = selectedRadioId;
	}
}
