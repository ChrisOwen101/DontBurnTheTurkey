package com.dontburnthe.turkey;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Recipe> {
	private final Context context;
	private final List<Recipe> recipes;
	private final View[] rowViews;
	ResizeAnimation animation;
	Typeface type;

	public ListAdapter(Context thread, List<Recipe> recipes) {
		super(thread, R.layout.custom_listview_selection_row, recipes);
		this.context = thread;
		this.recipes = recipes;
		rowViews = new View[recipes.size()];
		
		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf");

	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		rowViews[position] = convertView;

		if(rowViews[position]==null){
			LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowViews[position]=inflater.inflate(R.layout.custom_listview_selection_row, parent, false);
		}

		TextView textView = (TextView) rowViews[position].findViewById(R.id.text);
		textView.setText(recipes.get(position).name);
		
		textView.setTypeface(type);

		ImageView cross = (ImageView) rowViews[position].findViewById(R.id.cross);
		cross.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SharedPreferences settings = context.getSharedPreferences("veg", 0);
				String list = settings.getString("list", "");

				String[] listSplit = list.split(" ");
				list = list.replace(listSplit[position]+" ", "");

				SharedPreferences.Editor editor = settings.edit();
				editor.putString("list", list);
				editor.commit();

				removeListItem(rowViews[position], position);
				
				//recipes.remove(position);
				//notifyDataSetChanged();

			}
		});

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
				recipes.remove(positon);
				notifyDataSetChanged();
				animation.cancel();
			}
		},1000);

	}
}
