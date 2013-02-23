package com.survey.thesurvey;

import com.survey.thesurvey.MenuActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NextScreenActivity extends Activity {
	private RadioGroup rButtonGroup;
	private int selectedRadioId;
	private int id;
	public final static String EXTRA_MESSAGE = "com.survey.thesurvey.MESSAGE";
    private int flag = 0;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get message from the Intent
		Intent intent = getIntent();
		intent.getStringExtra(MenuActivity.EXTRA_MESSAGE);
		if(savedInstanceState != null){
			
			id = savedInstanceState.getInt("rbutton");
			RadioButton radioButton = (RadioButton) findViewById(id);
			radioButton.setChecked(true);
		}
		setContentView(R.layout.activity_next_screen);
	}


	public void onSaveInstanceState(Bundle savedInstanceState) {

		savedInstanceState.putInt("rbutton", id);
		
		  super.onSaveInstanceState(savedInstanceState);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_screen, menu);
		return true;
	}
	
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		  
		super.onRestoreInstanceState(savedInstanceState);
		  id = savedInstanceState.getInt("rbutton");
		}
	
	//called when the user clicks the Next button
		public void sendMessage(View view){
			//perform action
			if(flag==0){
				flag=1;
			rButtonGroup = (RadioGroup) findViewById(R.id.rbg_next_screen);
			if(rButtonGroup.getCheckedRadioButtonId()!=-1){
			    id= rButtonGroup.getCheckedRadioButtonId();
			    View radioButton = rButtonGroup.findViewById(id);
			    setSelectedRadioId(rButtonGroup.indexOfChild(radioButton));
			}
			Intent intent = new Intent(this, MidScreenActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(intent);
			
			}
			else{
				Intent intent = new Intent(this, MidScreenActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
			
		}

			public int getSelectedRadioId() {
				return selectedRadioId;
			}

			public void setSelectedRadioId(int selectedRadioId) {
				this.selectedRadioId = selectedRadioId;
			}
			
	}
