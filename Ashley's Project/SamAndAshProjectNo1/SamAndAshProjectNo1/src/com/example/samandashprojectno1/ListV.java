package com.example.samandashprojectno1;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListV extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter (new ArrayAdapter<String>(this, R.layout.single_item, Food));
		
		ListView list = getListView();
		list.setTextFilterEnabled(true);	// Don't no what it does
		
		list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), ((TextView) arg1).getText(), Toast.LENGTH_SHORT).show();
			}
			
			
		});
	}
	
	
	static final String[] Food = new String[] {
		"Ice Cream", "Apple", "Banana", "Cheese", "Sandwich", "Bread", "Muffin", "Bacon", "Rice"
		
	};
}
