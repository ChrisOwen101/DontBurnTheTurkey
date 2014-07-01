package com.dontburnthe.turkey;

import java.util.LinkedList;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class ShoppingList extends SherlockFragment{

	Data data = new Data();
	LinkedList<Recipe> recipes = new LinkedList<Recipe>();
	LinkedList<Ingredient> ingre = new LinkedList<Ingredient>();
	LinkedList<Integer> numPeople = new LinkedList<Integer>();

	ShoppingListAdapter adapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);


	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_shoppinglist, container, false);

		SharedPreferences settings = getActivity().getSharedPreferences("veg", 0);
		String list = settings.getString("list", "");

		String[] listSplit = list.split(" ");

		for(int i = 0; i<listSplit.length; i++){
			System.out.println(i + listSplit[i]);
		}

		for(int i = 0; i<listSplit.length; i++){
			for(int y = 0; y<listSplit[i].length(); y++){			
				if(listSplit[i].charAt(y) == ','){					
					String holdRecipe = listSplit[i].substring(0, y);
					recipes.add(data.recipes.get(Integer.parseInt(holdRecipe)));
				}
			}
		}

		for(int i = 0; i<recipes.size(); i++){
			if(recipes.get(i).section.equals("main")){
				for(int y = 0; y<recipes.get(i).usedIngre.size(); y++){
					ingre.add(recipes.get(i).usedIngre.get(y));
					numPeople.add(0);
				}
			}
			else{
				String holdNumber = listSplit[i].substring(listSplit[i].lastIndexOf(',') + 1);
				for(int y = 0; y<recipes.get(i).usedIngre.size(); y++){
					ingre.add(recipes.get(i).usedIngre.get(y));
					numPeople.add(Integer.parseInt(holdNumber));
				}
			}

		}

		adapter = new ShoppingListAdapter(getActivity(), ingre, numPeople);  
		ListView listView = (ListView)view.findViewById(R.id.listView1);
		listView.setEnabled(false);
		listView.setAdapter(adapter);
		
		Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/coneriascript.ttf"); 
		TextView premium = (TextView) view.findViewById(R.id.textView1);
		premium.setTypeface(type);
		
		RelativeLayout blocker = (RelativeLayout) view.findViewById(R.id.blocker);
		blocker.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});

		adapter.notifyDataSetChanged();

		return view;
	}

	public void onResume(){
		super.onResume();
		adapter.notifyDataSetChanged();
	}

}


