package com.example.samandashprojectno1;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class SamScreenActivity extends Activity implements OnCheckedChangeListener{
	TextView textOut;
	EditText getInput;
	RadioGroup rgGravity;
	RadioGroup rgStyle;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.samscreen);
		
		textOut = (TextView) findViewById(R.id.tvGetInput);
		getInput = (EditText) findViewById(R.id.etInput);
		Button ok = (Button) findViewById(R.id.okButton);
		rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
		
		rgStyle = (RadioGroup) findViewById(R.id.rgStyle);
		
		rgGravity.setOnCheckedChangeListener(this);
		rgStyle.setOnCheckedChangeListener(this);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textOut.setText(getInput.getText());
			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId){
			case R.id.rbLeft:
				int i = 100;
				textOut.setGravity(Gravity.LEFT);
				Log.d("Hey", "" + i);
				break;
			case R.id.rbCenter:
				textOut.setGravity(Gravity.CENTER);
				break;
			case R.id.rbRight:
				textOut.setGravity(Gravity.RIGHT);
				break;
			case R.id.rbPlain:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
				break;
			case R.id.rbBold:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
				break;
			case R.id.rbItalic:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
				break;
		}
	}
}
