package com.dontburnthe.turkey;

import java.util.LinkedList;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dontburnthe.turkey.AnimationFactory.FlipDirection;

public class Extras extends SherlockActivity {

	Context context = this;

	boolean[] flipped = {false,false,false,false,false,false,false,false,false};
	ViewAnimator[] panels = new ViewAnimator[9];
	TextView[] text = new TextView[9];
	Button[] button = new Button[18];

	Data data = new Data();

	LinkedList<Recipe> recipes = new LinkedList<Recipe>();

	Typeface type;

	MenuItem view;
	MenuItem done;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extra);
		
		type = Typeface.createFromAsset(this.getAssets(), "fonts/coneriascript.ttf");
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.actionbar_title, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
		titleTV.setText("Choose Your Extras:");
		titleTV.setTypeface(type,1);
		titleTV.setTextSize(16);
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);

		panels[0] = (ViewAnimator)this.findViewById(R.id.viewFlipper1);
		panels[1] = (ViewAnimator)this.findViewById(R.id.viewFlipper2);
		panels[2] = (ViewAnimator)this.findViewById(R.id.viewFlipper3);
		panels[3] = (ViewAnimator)this.findViewById(R.id.viewFlipper4);
		panels[4] = (ViewAnimator)this.findViewById(R.id.viewFlipper5);
		panels[5] = (ViewAnimator)this.findViewById(R.id.viewFlipper6);
		panels[6] = (ViewAnimator)this.findViewById(R.id.viewFlipper7);
		panels[7] = (ViewAnimator)this.findViewById(R.id.viewFlipper8);
		panels[8] = (ViewAnimator)this.findViewById(R.id.viewFlipper9);

		text[0] = (TextView)this.findViewById(R.id.textView1);
		text[1] = (TextView)this.findViewById(R.id.textView2);
		text[2] = (TextView)this.findViewById(R.id.textView3);
		text[3] = (TextView)this.findViewById(R.id.textView4);
		text[4] = (TextView)this.findViewById(R.id.textView5);
		text[5] = (TextView)this.findViewById(R.id.textView6);
		text[6] = (TextView)this.findViewById(R.id.textView7);
		text[7] = (TextView)this.findViewById(R.id.textView8);
		text[8] = (TextView)this.findViewById(R.id.textView9);

		button[0] = (Button)this.findViewById(R.id.button1);
		button[1] = (Button)this.findViewById(R.id.button2);
		button[2] = (Button)this.findViewById(R.id.button3);
		button[3] = (Button)this.findViewById(R.id.button4);
		button[4] = (Button)this.findViewById(R.id.button5);
		button[5] = (Button)this.findViewById(R.id.button6);
		button[6] = (Button)this.findViewById(R.id.button7);
		button[7] = (Button)this.findViewById(R.id.button8);
		button[8] = (Button)this.findViewById(R.id.button9);
		button[9] = (Button)this.findViewById(R.id.button10);
		button[10] = (Button)this.findViewById(R.id.button11);
		button[11] = (Button)this.findViewById(R.id.button12);
		button[12] = (Button)this.findViewById(R.id.button13);
		button[13] = (Button)this.findViewById(R.id.button14);
		button[14] = (Button)this.findViewById(R.id.button15);
		button[15] = (Button)this.findViewById(R.id.button16);
		button[16] = (Button)this.findViewById(R.id.button17);
		button[17] = (Button)this.findViewById(R.id.button18);

		for(int i = 0; i<data.recipes.size(); i++){
			if(data.recipes.get(i).section.equals("extras")){
				recipes.add(data.recipes.get(i));
			}
		}

		for(int y = 0; y<button.length; y++){
			if (y % 2 == 0) {
				button[y].setOnClickListener(new OnClickListener() {
					public void onClick(View v) {				

						int position = 0;

						for(int i = 0; i<button.length; i++){
							if(button[i].equals(v)){
								position = (i)/2;
							}
						}

						final Dialog dialog = new Dialog(context);
						dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
						dialog.setContentView(R.layout.custom_dialog);

						TextView ingredients = (TextView) dialog.findViewById(R.id.Ingredients);			
						TextView steps = (TextView) dialog.findViewById(R.id.Recipe);
						TextView ingredientstitle = (TextView) dialog.findViewById(R.id.IngredientsTitle);			
						TextView stepstitle = (TextView) dialog.findViewById(R.id.RecipeTitle);

						String ingredientList = "";
						String stepList = "";
						for(int i = 0; i<recipes.get(position).usedIngre.size(); i++){
							ingredientList = ingredientList + recipes.get(position).usedIngre.get(i).name + " - " + recipes.get(position).usedIngre.get(i).quantity+ "\n";
						}
						for(int i = 0; i<recipes.get(position).steps.size(); i++){
							stepList = stepList + recipes.get(position).steps.get(i).title + "\n" + recipes.get(position).steps.get(i).desc + " - " + recipes.get(position).steps.get(i).time + " minutes\n";
						}
						
						ingredients.setText(ingredientList);
						steps.setText(stepList);

						TextView title = (TextView) dialog.findViewById(R.id.title);
						title.setText(recipes.get(position).name);
						title.setTypeface(type);
						ingredientstitle.setTypeface(type);
						stepstitle.setTypeface(type);


						Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
						dialogButton.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
							}
						});

						ImageView im = (ImageView) dialog.findViewById(R.id.image);

						if(recipes.get(position).mainIngre.name.equals("Stale bread")){
							im.setImageResource(R.drawable.breadsauce);
						}
						else if(recipes.get(position).mainIngre.name.equals("Cranberries")){
							im.setImageResource(R.drawable.cranberry);
						}
						else if(recipes.get(position).mainIngre.name.equals("Sausage meat")){
							im.setImageResource(R.drawable.stuffing);
						}
						else if(recipes.get(position).mainIngre.name.equals("16 Cocktail sausages")){
							im.setImageResource(R.drawable.pigsinblankets);
						}
						else if(recipes.get(position).mainIngre.name.equals("Cooking apples")){
							im.setImageResource(R.drawable.applesauce);
						}
						else if(recipes.get(position).mainIngre.name.equals("Flour")){
							im.setImageResource(R.drawable.yorkshirepudding);
						}
						else if(recipes.get(position).mainIngre.name.equals("Fresh horseradish")){
							im.setImageResource(R.drawable.horseradish);
						}
						else if(recipes.get(position).mainIngre.name.equals("Redcurrants")){
							im.setImageResource(R.drawable.redcurrentjelly);
						}

						dialog.show();
					}
				});
			} else {
				button[y].setOnClickListener(new OnClickListener() {
					public void onClick(View v) {		
						int position = 0;

						for(int i = 0; i<button.length; i++){
							if(button[i].equals(v)){
								position = (i+1)/2;
							}
						}
						
						int positionRecipe = 0;
						for(int i = 0; i<data.recipes.size(); i++){
							if(recipes.get(position).equals(data.recipes.get(i))){
								positionRecipe = i;
							}
						}

						SharedPreferences settings = context.getSharedPreferences("veg", 0);
						String list = settings.getString("list", "");

						list = list + positionRecipe + "," + "0" + " ";
						System.out.println(list);

						SharedPreferences.Editor editor = settings.edit();
						editor.putString("list", list);
						editor.commit();

						Toast.makeText(context,"Extra added to selection.", Toast.LENGTH_SHORT).show();
					}
				});
			}
			button[y].setTypeface(type);
		}




		for(int y = 0; y<panels.length; y++){

			text[y].setTypeface(type,1);


			panels[y].setOnClickListener(new OnClickListener() {
				public void onClick(View v) {				
					int panelNumber = 0;

					for(int i = 0; i<panels.length; i++){
						if(v.equals(panels[i])){
							panelNumber = i;
						}
					}

					AnimationFactory.flipTransition(panels[panelNumber], FlipDirection.LEFT_RIGHT);

					for(int i = 0; i<flipped.length; i++){
						if(flipped[i] == true){
							AnimationFactory.flipTransition(panels[i], FlipDirection.RIGHT_LEFT);
							flipped[i] = false;
						}
					}

					flipped[panelNumber] = true;
				}
			});
		}
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
			SharedPreferences settings = context.getSharedPreferences("firstTime", 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putInt("first", 1);
			editor.commit();
			
			Intent intent = new Intent(Extras.this, Main.class);
			startActivity(intent);
		}
		else if(item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
