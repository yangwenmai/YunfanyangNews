package com.yunfanyang.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private final int columnWidthPX = 55;
	private int mColumnWidthDip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] categoryArray = getResources().getStringArray(R.array.categories);
		GridView category = new GridView(this);
		category.setColumnWidth(columnWidthPX);
		category.setNumColumns(GridView.AUTO_FIT);
		category.setGravity(Gravity.CENTER);
		
		
		List<Map<String, String>> categories = new ArrayList<Map<String, String>>();
		for (int i = 0; i < categoryArray.length; i++) {
			HashMap<String, String> object = new HashMap<String, String>();
			object.put("category_title", categoryArray[i]);
			categories.add(object);
		}
		SimpleAdapter categoryAdapter = new SimpleAdapter(this, categories, R.layout.category_title, new String[]{"category_title"}, new int[]{R.id.category_title});
		int width = columnWidthPX*categories.size();
		LayoutParams params = new LayoutParams(width, LayoutParams.WRAP_CONTENT);
		category.setLayoutParams(params);
		category.setAdapter(categoryAdapter);
		
		LinearLayout categoryLayout = (LinearLayout)findViewById(R.id.category_layout);
		categoryLayout.addView(category);
		
		final HorizontalScrollView categoryScrollView = (HorizontalScrollView)findViewById(R.id.category_scrollview);
		
		Button categoryArrowRight = (Button) findViewById(R.id.category_arrow_right);
		categoryArrowRight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				categoryScrollView.fling(800);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
