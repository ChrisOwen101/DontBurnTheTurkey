package com.dontburnthe.turkey;

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<Recipe>{

	Context context;
	List<Recipe> recipes;
	Typeface type;
	int multiplier;

	public SpinnerAdapter(Context context, int textViewResourceId,List<Recipe> recipes, int multiplier) {
		super(context, textViewResourceId, recipes);
		this.context = context;
		this.recipes = recipes;
		this.multiplier = multiplier;

	}

	@Override
	public View getDropDownView(int position, View convertView,
			ViewGroup parent) {

		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return getCustomView(position, convertView, parent);
	}

	public View getCustomView(final int position, View convertView, ViewGroup parent) {

		//return super.getView(position, convertView, parent);

		LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View row = inf.inflate(R.layout.spinner_row, parent, false);

		TextView label=(TextView)row.findViewById(R.id.weekofday);
		label.setText(recipes.get(position).name);

		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf"); 
		label.setTypeface(type);

		TextView button = (TextView) row.findViewById(R.id.button1);
		button.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {

				if(recipes.get(position).isPremium == true){
					AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
					alertbox.setTitle("Premium Version Only!");
					alertbox.setMessage("Unfortunatly, this recipe is restricted to premium users only. To gain access to this recipe you can get the Don't Burn The Turkey Premium version from the Play Store.");
					alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							arg0.dismiss();
						}
					});

					// show it
					alertbox.show();
				}
				else{

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
						ingredientList = ingredientList + recipes.get(position).usedIngre.get(i).name + " - " + recipes.get(position).usedIngre.get(i).quantity*multiplier + "\n";
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

					if(recipes.get(position).mainIngre.name.equals("Carrots")){
						im.setImageResource(R.drawable.carrots);
					}
					else if(recipes.get(position).mainIngre.name.equals("Brocolli")){
						im.setImageResource(R.drawable.brocolli);
					}
					else if(recipes.get(position).mainIngre.name.equals("Cauliflower")){
						im.setImageResource(R.drawable.cauliflowers);
					}
					else if(recipes.get(position).mainIngre.name.equals("Peas")){
						im.setImageResource(R.drawable.peas);
					}
					else if(recipes.get(position).mainIngre.name.equals("Sweetcorn")){
						im.setImageResource(R.drawable.sweetcorn);
					}
					else if(recipes.get(position).mainIngre.name.equals("Sprouts")){
						im.setImageResource(R.drawable.sprouts);
					}
					else if(recipes.get(position).mainIngre.name.equals("Savoy cabbage")){
						im.setImageResource(R.drawable.cabbage);
					}
					else if(recipes.get(position).mainIngre.name.equals("Potatoes")){
						im.setImageResource(R.drawable.potatoes);
					}
					else if(recipes.get(position).mainIngre.name.equals("Parsnips")){
						im.setImageResource(R.drawable.parsnips);
					}
					else if(recipes.get(position).mainIngre.name.equals("Butternut Squash")){
						im.setImageResource(R.drawable.butternutsquash);
					}
					else if(recipes.get(position).mainIngre.name.equals("Fennel")){
						im.setImageResource(R.drawable.fennel);
					}
					else if(recipes.get(position).mainIngre.name.equals("Sweet Potatoe")){
						im.setImageResource(R.drawable.sweetpotatoe);
					}
					else if(recipes.get(position).mainIngre.name.equals("Swede")){
						im.setImageResource(R.drawable.swede);
					}

					dialog.show();
					return false;
				}
				return false;
			}
		});
		return row;
	}
}