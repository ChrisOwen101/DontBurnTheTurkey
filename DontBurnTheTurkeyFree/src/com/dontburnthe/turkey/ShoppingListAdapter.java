package com.dontburnthe.turkey;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class ShoppingListAdapter extends ArrayAdapter<Ingredient> {
	private final Context context;
	private final List<Ingredient> ingre;
	private final LinkedList<Integer> numPeople;
	private final View[] rowViews;
	private final CheckBox[] checkBox;
	private final Boolean[] checked;
	ResizeAnimation animation;
	Typeface type;

	public ShoppingListAdapter(Context thread, List<Ingredient> ingre,LinkedList<Integer> numPeople) {
		super(thread, R.layout.custom_listview_shopping_row, ingre);
		this.context = thread;
		this.ingre = ingre;
		rowViews = new View[ingre.size()];
		checkBox = new CheckBox[ingre.size()];
		checked = new Boolean[ingre.size()];
		this.numPeople = numPeople;
		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf");


		for(int i = 0; i<checked.length; i++){
			checked[i] = false;
		}
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		notifyDataSetChanged();
		rowViews[position] = convertView;

		if(rowViews[position]==null){
			LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowViews[position]=inflater.inflate(R.layout.custom_listview_shopping_row, parent, false);
		}

		TextView textView = (TextView) rowViews[position].findViewById(R.id.item);
		textView.setText(ingre.get(position).name);
		textView.setTypeface(type);

		TextView textView2 = (TextView) rowViews[position].findViewById(R.id.amount);
		String amount = Float.toString(ingre.get(position).quantity*numPeople.get(position));
		if(numPeople.get(position) == 0){
			textView2.setText(" ");
			textView2.setTypeface(type);
		}
		else{
			amount = amount.substring(0, amount.length() - 2);
			amount = amount + "g";
			textView2.setText(amount);
			textView2.setTypeface(type);
		}

		checkBox[position] = (CheckBox) rowViews[position].findViewById(R.id.checkBox1);

		checkBox[position].setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				if (buttonView.isChecked()){
					checked[position] = true;
				}
				else{
					checked[position] = false;
				}

			}
		});

		checkBox[position].setChecked(checked[position]);

		return rowViews[position];

	}

	protected void removeListItem(View rowView, final int positon) {
		animation = new ResizeAnimation(rowView, 1,100, false);
		animation.setDuration(1000);
		rowView.startAnimation(animation);
		Handler handle = new Handler();
		handle.postDelayed(new Runnable() {

			@Override
			public void run() {
				ingre.remove(positon);
				notifyDataSetChanged();
				animation.cancel();
			}
		},1000);

	}
}
