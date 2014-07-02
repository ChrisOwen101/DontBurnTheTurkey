package com.dontburnthe.turkey;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Timer extends SherlockActivity {

	Calendar startTime;
	Data data = new Data();
	int longestRecipe = 0;
	LinkedList<Recipe> recipes = new LinkedList<Recipe>();
	TimerListAdapter adapter;
	
	MenuItem pause;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
		alertbox.setTitle("Lets Get Cooking!");
		alertbox.setMessage("To use this section of the app simply look through the list and complete the tasks that have the least time left. If you finish a task early you can click the 'Done!' button to continue on the next step. " +
				"\nImportant note: The times shown here are only guidelines! We cannot account for the many different factors that can effect cooking time so please to not relie solely on Don't Burn The Turkey! ");
		alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				arg0.dismiss();
			}
		});

		// show it
		alertbox.show();

		ActionBar bar = getSupportActionBar();

		Bundle extras = getIntent().getExtras(); 
		startTime = Calendar.getInstance();

		if (extras != null) {
			startTime.set(Calendar.MINUTE, extras.getInt("minute"));
			startTime.set(Calendar.HOUR_OF_DAY, extras.getInt("hour"));
			startTime.set(Calendar.DAY_OF_MONTH, extras.getInt("day"));
			startTime.set(Calendar.MONTH, extras.getInt("month"));
			startTime.set(Calendar.YEAR, extras.getInt("year"));
		}

		//Get Selected
		SharedPreferences settings = this.getSharedPreferences("veg", 0);
		String savedList = settings.getString("list", "");

		String[] listSplit = savedList.split(" ");

		for(int i = 0; i<listSplit.length; i++){
			for(int y = 0; y<listSplit[i].length(); y++){
				if(listSplit[i].charAt(y) == ','){
					String holdNumber = listSplit[i].substring(0, y);
					recipes.add(data.recipes.get(Integer.parseInt(holdNumber)));
				}
			}
		}

		//Setup Listview for each of the different elements to be cooked
		ArrayList<ArrayList<Step>> steps = new ArrayList<ArrayList<Step>>();
		ArrayList<Step> list;

		for(int i = 0; i<recipes.size(); i++){
			list = new ArrayList<Step>();
			for(int y = 0; y<recipes.get(i).steps.size(); y++){
				if(recipes.get(i).section.equals("main")){
					if(recipes.get(i).steps.get(y).time == 0f){
						String holdNumber = listSplit[i].substring(listSplit[i].lastIndexOf(',') + 1);
						recipes.get(i).steps.get(y).time = Integer.parseInt(holdNumber);
						System.out.println("MEAT: " + recipes.get(i).steps.get(y).time);
						list.add(recipes.get(i).steps.get(y));
					}
					else{
						list.add(recipes.get(i).steps.get(y));
					}	
				}
				else{
					list.add(recipes.get(i).steps.get(y));
				}

			}
			steps.add(list);
		}

		//Get longest recipe
		for(int i = 0; i<recipes.size(); i++){
			int recipeLength = 0;

			for(int y = 0; y<recipes.get(i).steps.size(); y++){
				recipeLength = recipeLength + recipes.get(i).steps.get(y).time;
			}

			if(recipeLength > longestRecipe){
				longestRecipe = recipeLength;
			}
		}

		adapter = new TimerListAdapter(getBaseContext(), steps, startTime);  
		ListView listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(adapter);

	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which){
				case DialogInterface.BUTTON_POSITIVE:	
					adapter.on = false;  
					finish();
					adapter = null;
					Intent intent = new Intent(Timer.this, Main.class);
					startActivity(intent);
					break;
				case DialogInterface.BUTTON_NEGATIVE:
					dialog.dismiss();
					break;
				}
			}
		};

		builder.setMessage("Are you sure you want quit. Quitting now will reset all timers.").setPositiveButton("Yes", dialogClickListener)
		.setNegativeButton("No", dialogClickListener).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		pause = menu.add("Pause");
		pause.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.equals(pause)){
			if(adapter.isPaused == false){
				pause.setTitle("Play");
				adapter.isPaused = true;
			}
			else{
				pause.setTitle("Pause");
				adapter.isPaused = false;
			}	
		}
		return super.onOptionsItemSelected(item);
	}

}
