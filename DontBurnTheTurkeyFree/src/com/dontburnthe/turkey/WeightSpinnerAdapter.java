package com.dontburnthe.turkey;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
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

public class WeightSpinnerAdapter extends ArrayAdapter<String>{

	Context context;
	Typeface type;
	String[] weights;

	public WeightSpinnerAdapter(Context context, String[] weights) {
		super(context, R.layout.weight_spinner_row, weights);
		this.context = context;
		this.weights = weights;
		
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
		View row = inf.inflate(R.layout.weight_spinner_row, parent, false);

		TextView label=(TextView)row.findViewById(R.id.weekofday);
		label.setText(weights[position]);

		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf"); 
		label.setTypeface(type);
		
		return row;
	}
}