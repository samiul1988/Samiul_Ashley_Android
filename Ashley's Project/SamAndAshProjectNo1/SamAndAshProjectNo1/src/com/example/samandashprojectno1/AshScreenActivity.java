package com.example.samandashprojectno1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AshScreenActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ashleyscreen);
		
		Button bAshBack = (Button) findViewById(R.id.ashBack);
		bAshBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.samandashprojectno1.MAINSCREEN"));
				finish();
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	// inflate with the menu
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.menuSweet:
			startActivity(new Intent("com.example.samandashprojectno1.SWEET"));
			return true;
		case R.id.menuToast:
			Toast t = Toast.makeText(this, "From Toast", Toast.LENGTH_SHORT);
			t.show();
			return true;
		}
		return false;
	}
	
}
