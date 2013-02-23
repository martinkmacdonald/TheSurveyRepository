package com.survey.thesurvey;
import com.survey.thesurvey.MidScreenActivity;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioGroup;

public class LastScreenActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.survey.thesurvey.MESSAGE";
	private RadioGroup rButtonGroup;
	private int selectedRadioId=-1;
	private int id;
    private int flag = 0;
    
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//get message from the Intent
		Intent intent = getIntent();
		intent.getStringExtra(MidScreenActivity.EXTRA_MESSAGE);
		
		setContentView(R.layout.activity_last_screen);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last_screen, menu);
		return true;
	}
	
	//called when the user clicks the Finish button
	public void sendMessage(View view){
		//perform action
		
		if(flag==0){
			flag=1;
			rButtonGroup = (RadioGroup) findViewById(R.id.rbg_last_screen);
			if(rButtonGroup.getCheckedRadioButtonId()!=-1){
			    id= rButtonGroup.getCheckedRadioButtonId();
			    View radioButton = rButtonGroup.findViewById(id);
			    setSelectedRadioId(rButtonGroup.indexOfChild(radioButton));
			}
			Intent intent = new Intent(this, EndActivity.class);
			startActivity(intent);
			finish();
			return;
			}
			else{
				Intent intent = new Intent(this, EndActivity.class);
				startActivity(intent);
				finish();
				return;
			}
	}
	//called when the user clicks the previous button
	public void sendMessageBack(View view){
		//perform action
		Intent intent = new Intent(this, MidScreenActivity.class);
		startActivity(intent);
	}
	
	public int getSelectedRadioId() {
		return selectedRadioId;
	}

	public void setSelectedRadioId(int selectedRadioId) {
		this.selectedRadioId = selectedRadioId;
	}

}
