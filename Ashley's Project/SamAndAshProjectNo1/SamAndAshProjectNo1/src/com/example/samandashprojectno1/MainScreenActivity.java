package com.example.samandashprojectno1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


	
public class MainScreenActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.buttonclicking);
		
		Button bSam = (Button) findViewById(R.id.sam);
		bSam.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				mp.start();
				
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.samandashprojectno1.SAMSCREEN"));
				// finish();
			}
		});
		
		Button bAsh = (Button) findViewById(R.id.ash);
		bAsh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				mp.start();
				
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.samandashprojectno1.ASHSCREEN"));
				//finish();
			}
		});
		
		Button bListV = (Button)findViewById(R.id.ListV);
		bListV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.samandashprojectno1.LISTVIEW"));
			}
		});
		
		
		Button bEnd = (Button) findViewById(R.id.end);
		bEnd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println ("Main Activity onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println ("Main Activity onPause");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
}
