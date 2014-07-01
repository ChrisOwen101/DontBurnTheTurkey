package com.dontburnthe.turkey;

import java.util.LinkedList;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ViewSelectionDialog extends Dialog{
	
	Data data = new Data();
	LinkedList<Recipe> recipes;

	public ViewSelectionDialog(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.custom_view_selection);
		
		recipes = new LinkedList<Recipe>();
		
		SharedPreferences settings = context.getSharedPreferences("veg", 0);
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
		
		ListAdapter adapter = new ListAdapter(context, recipes);  
        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        
        Typeface type = Typeface.createFromAsset(getContext().getAssets(),"fonts/coneriascript.ttf"); 
        TextView title = (TextView) findViewById(R.id.title);
        title.setTypeface(type);
		
		Button dialogButton = (Button) findViewById(R.id.dialogButtonOK);
		dialogButton.getBackground().setColorFilter(new LightingColorFilter(0xFF8F000B,0xFF8F000B));
		dialogButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dismiss();
			}
		});
		
	}
	
	

}
