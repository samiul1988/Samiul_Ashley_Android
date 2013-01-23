package com.example.samandashproject2_converter;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;



public class MainActivity extends Activity {
	
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial_screen);
		
		mp = MediaPlayer.create(this, R.raw.init_screen_sound);
		mp.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					int time = 0;
					while(time < 50){
						sleep(100);
						time++;
					}
					startActivity(new Intent("com.example.samandashproject2_converter.MAINSCREEN"));
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					finish();
				}
			}
		};
		timer.start();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
