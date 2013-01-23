package com.example.samandashproject2_converter;

import com.example.samandashproject2_converter.TemperatureActivity.ConvertType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WeightActivity extends Activity implements OnItemSelectedListener{
	
	public enum ConvertType {PTOK, KTOP};
	
	ConvertType ct = ConvertType.PTOK;
	
	EditText weightIn;
	
	TextView textOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weight_converter_screen);
		
		final Spinner sWeight;
		
		Button bConvert = (Button) findViewById(R.id.convert_button_weight);
		Button bGoMain = (Button) findViewById(R.id.weight_to_main_button);
		Button bGoTemp = (Button) findViewById(R.id.weight_to_temp_button);
		
		weightIn = (EditText) findViewById(R.id.weightInput);
		textOut = (TextView) findViewById(R.id.weightOutput);
		
		sWeight = (Spinner) findViewById(R.id.s_weight);
		sWeight.setOnItemSelectedListener(this);
		
		bConvert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				double input = Double.parseDouble(weightIn.getText().toString());
				switch (ct){
					case PTOK:
						Double pToKResult = input / 2.2046;
						textOut.setText(pToKResult.toString());
						break;
					case KTOP:
						Double kToPResult = input * 2.2046;
						Log.d("Temp", "input = " + input + " Result = " + kToPResult);
						textOut.setText(kToPResult.toString());
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
		
		bGoTemp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent ("com.example.samandashproject2_converter.TEMPERATURE"));
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
		// TODO Auto-generated method stub
		switch(arg2){
		case 0:
			ct = ConvertType.PTOK;
			break;
		case 1:
			ct = ConvertType.KTOP;
			Log.d("debug", "here is case 1" + arg2);
			break;
		
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
