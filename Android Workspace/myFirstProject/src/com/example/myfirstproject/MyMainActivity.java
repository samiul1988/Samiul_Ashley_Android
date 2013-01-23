package com.example.myfirstproject;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MyMainActivity extends Activity {
	MediaPlayer sound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		sound = MediaPlayer.create(this, R.raw.voice0001);
		
		sound.start();
		Thread logoTimer = new Thread(){
			public void run(){
				try {
					int logoTimer = 0;
					while(logoTimer < 5000){
						sleep(100); /** 100 = 10th of a second**/
						logoTimer = logoTimer + 100;
					}
					startActivity(new Intent("com.example.myfirstproject.CLEARSCREEN"));	
					 
					
					
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					finish(); /** finish MyMainActivity**/
				}
			}
		};
		logoTimer.start();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		sound.release();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sound.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sound.start();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
//	/**
//	/** Called when activity is first created **/
//	String words = "This is the value of the reference words";
//	int numbers = 1234;
//	boolean lightswitch = false;
//	short smallnumber = 13;
//	long longernumber = 324;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_my_main, menu);
//        return true;
//    }
    
	
    
}
