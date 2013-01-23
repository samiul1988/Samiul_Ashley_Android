package com.example.samandashproject2_converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class TemperatureActivity extends Activity implements OnItemSelectedListener{
	
	public enum ConvertType {CTOF, FTOC};
	
	ConvertType ct = ConvertType.CTOF;
	
	EditText tempIn;

	TextView textOut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature_converter_screen);
		
		final Spinner sTemp;
		
		tempIn = (EditText) findViewById(R.id.tempInput);
		
		Button bConvert = (Button) findViewById(R.id.convert_button_temp);
		Button bGoMain = (Button) findViewById(R.id.temp_to_main_button);
		Button bGoWeight = (Button) findViewById(R.id.temp_to_weight_button);
		
		sTemp = (Spinner) findViewById(R.id.spinner_temp);
		sTemp.setOnItemSelectedListener(this);
		
		
		textOut = (TextView) findViewById(R.id.tempOutput);
		textOut.setText("");
		
		//ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
		//aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//sTemp.setAdapter(aa);
		
		bConvert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double input = Double.parseDouble(tempIn.getText().toString());
				switch (ct){
					case CTOF:
						Double cToFResult = 1.8 * input + 32;
						textOut.setText(cToFResult.toString());
						break;
					case FTOC:
						Double fToCResult = 5.0 / 9 * (input - 32);
						Log.d("Temp", "input = " + input + " Result = " + fToCResult);
						textOut.setText(fToCResult.toString());
						break;
				}
				
			}
		});
		
		bGoMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent ("com.example.samandashproject2_converter.MAINSCREEN"));
				finish();
			}
		});
		
		bGoWeight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent ("com.example.samandashproject2_converter.WEIGHT"));
				finish();
			}
		});
		
	}

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		//textOut = (TextView) findViewById(R.id.tempOutput);
		//textOut.setText("");
		// TODO Auto-generated method stub
		
		switch(arg2){
		case 0:
			ct = ConvertType.CTOF;
			break;
		case 1:
			ct = ConvertType.FTOC;
			Log.d("debug", "here is case 1" + arg2);
			break;
		
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		textOut.setText("");
	}
	
}
