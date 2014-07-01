package com.dontburnthe.turkey;

import java.util.LinkedList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

public class Review extends SherlockFragment{

	Data data = new Data();
	LinkedList<Recipe> recipes;
	Typeface type;

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_review, container, false);
		
		type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/coneriascript.ttf");

		recipes = new LinkedList<Recipe>();

		SharedPreferences settings = getActivity().getSharedPreferences("veg", 0);
		String list = settings.getString("list", "");

		String[] listSplit = list.split(" ");

		for(int i = 0; i<listSplit.length; i++){
			for(int y = 0; y<listSplit[i].length(); y++){
				if(listSplit[i].charAt(y) == ','){
					listSplit[i] = listSplit[i].substring(0, y);
					recipes.add(data.recipes.get(Integer.parseInt(listSplit[i])));
				}
			}
		}

		ListAdapter adapter = new ListAdapter(getActivity(), recipes);  
		ListView listView = (ListView)view.findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		Button main = (Button) view.findViewById(R.id.button1);
		Button veg = (Button) view.findViewById(R.id.button2);
		Button extra = (Button) view.findViewById(R.id.button3);
		
		main.setTypeface(type);
		veg.setTypeface(type);
		extra.setTypeface(type);
		
		main.setTextColor(Color.WHITE);
		veg.setTextColor(Color.WHITE);
		extra.setTextColor(Color.WHITE);
		
		main.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				getActivity().finish();
				Intent intent = new Intent(getActivity(), Meat.class);
				startActivity(intent);
			}
		});
		
		veg.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				getActivity().finish();
				Intent intent = new Intent(getActivity(), Veg.class);
				startActivity(intent);
			}
		});
		
		extra.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				getActivity().finish();
				Intent intent = new Intent(getActivity(), Extras.class);
				startActivity(intent);
			}
		});

		return view;
	}

}
