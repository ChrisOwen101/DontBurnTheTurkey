package com.dontburnthe.turkey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Veg extends SherlockActivity {

	/** Called when the activity is first created. */
	private ExpandListAdapter ExpAdapter;
	private ArrayList<ExpandListGroup> ExpListItems;
	private ExpandableListView ExpandList;
	
	Context context = this;
	
	MenuItem view;
	MenuItem done;
	
	Typeface type;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_veg);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandListAdapter(Veg.this, ExpListItems, ExpandList);
		ExpandList.setAdapter(ExpAdapter);
		
		type = Typeface.createFromAsset(this.getAssets(),"fonts/coneriascript.ttf"); 

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.actionbar_title, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
		titleTV.setText("Choose Your Veg:");
		titleTV.setTypeface(type,1);
		titleTV.setTextSize(16);
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);

		/*actionBar.setDisplayShowTitleEnabled(false);

		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_title, null);

		TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);

		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);*/
	}

	public ArrayList<ExpandListGroup> SetStandardGroups() {
		ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
		ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru1 = new ExpandListGroup();
		gru1.setName("Carrots");
		ExpandListChild ch1_1 = new ExpandListChild();
		ch1_1.setName("Carrots");
		ch1_1.setTag(null);
		list2.add(ch1_1);
		gru1.setItems(list2);
		list.add(gru1);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru2 = new ExpandListGroup();
		gru2.setName("Broccoli");
		ExpandListChild ch2_1 = new ExpandListChild();
		ch2_1.setName("Broccoli");
		ch2_1.setTag(null);
		list2.add(ch2_1);
		gru2.setItems(list2);
		list.add(gru2);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru3 = new ExpandListGroup();
		gru3.setName("Cauliflower");
		ExpandListChild ch3_1 = new ExpandListChild();
		ch3_1.setName("Cauliflower");
		ch3_1.setTag(null);
		list2.add(ch3_1);
		gru3.setItems(list2);
		list.add(gru3);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru4 = new ExpandListGroup();
		gru4.setName("Peas");
		ExpandListChild ch4_1 = new ExpandListChild();
		ch4_1.setName("Peas");
		ch4_1.setTag(null);
		list2.add(ch4_1);
		gru4.setItems(list2);
		list.add(gru4);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru5 = new ExpandListGroup();
		gru5.setName("Sweetcorn");
		ExpandListChild ch5_1 = new ExpandListChild();
		ch5_1.setName("Sweetcorn");
		ch5_1.setTag(null);
		list2.add(ch5_1);
		gru5.setItems(list2);
		list.add(gru5);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru6 = new ExpandListGroup();
		gru6.setName("Sprouts");
		ExpandListChild ch6_1 = new ExpandListChild();
		ch6_1.setName("Sprouts");
		ch6_1.setTag(null);
		list2.add(ch6_1);
		gru6.setItems(list2);
		list.add(gru6);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru7 = new ExpandListGroup();
		gru7.setName("Cabbage");
		ExpandListChild ch7_1 = new ExpandListChild();
		ch7_1.setName("Cabbage");
		ch7_1.setTag(null);
		list2.add(ch7_1);
		gru7.setItems(list2);
		list.add(gru7);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru8 = new ExpandListGroup();
		gru8.setName("Potatoes");
		ExpandListChild ch8_1 = new ExpandListChild();
		ch8_1.setName("Potatoes");
		ch8_1.setTag(null);
		list2.add(ch8_1);
		gru8.setItems(list2);
		list.add(gru8);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru9 = new ExpandListGroup();
		gru9.setName("Parsnips");
		ExpandListChild ch9_1 = new ExpandListChild();
		ch9_1.setName("Parsnips");
		ch9_1.setTag(null);
		list2.add(ch9_1);
		gru9.setItems(list2);
		list.add(gru9);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru10 = new ExpandListGroup();
		gru10.setName("Butternut Squash");
		ExpandListChild ch10_1 = new ExpandListChild();
		ch10_1.setName("Butternut Squash");
		ch10_1.setTag(null);
		list2.add(ch10_1);
		gru10.setItems(list2);
		list.add(gru10);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru11 = new ExpandListGroup();
		gru11.setName("Fennel");
		ExpandListChild ch11_1 = new ExpandListChild();
		ch11_1.setName("Fennel");
		ch11_1.setTag(null);
		list2.add(ch11_1);
		gru11.setItems(list2);
		list.add(gru11);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru12 = new ExpandListGroup();
		gru12.setName("Sweet Potatoe");
		ExpandListChild ch12_1 = new ExpandListChild();
		ch12_1.setName("Sweet Potatoe");
		ch12_1.setTag(null);
		list2.add(ch12_1);
		gru12.setItems(list2);
		list.add(gru12);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru13 = new ExpandListGroup();
		gru13.setName("Swede");
		ExpandListChild ch13_1 = new ExpandListChild();
		ch13_1.setName("Swede");
		ch13_1.setTag(null);
		list2.add(ch13_1);
		gru13.setItems(list2);
		list.add(gru13);
		
		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru14 = new ExpandListGroup();
		gru14.setName("Courgette");
		ExpandListChild ch14_1 = new ExpandListChild();
		ch14_1.setName("Courgette");
		ch14_1.setTag(null);
		list2.add(ch14_1);
		gru14.setItems(list2);
		list.add(gru14);

		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		view = menu.add("View Selection");
		view.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		
		done = menu.add("Done");
		done.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    if(item.equals(view)){
	    	ViewSelectionDialog dialog = new ViewSelectionDialog(context);
	    	dialog.show();
	    }
	    else if(item.equals(done)){
	    	SharedPreferences settings = getSharedPreferences("firstTime", 0);
			int list = settings.getInt("first", 0);
			
			if(list == 1){
				Intent intent = new Intent(Veg.this, Main.class);
				startActivity(intent);
			}
			else{
				Intent intent = new Intent(Veg.this, Extras.class);
				startActivity(intent);
			}
	    }
	    else if(item.getItemId() == android.R.id.home) {
	        finish();
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
}
