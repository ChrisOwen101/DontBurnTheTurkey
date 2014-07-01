package com.dontburnthe.turkey;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ExpandListGroup> groups;
	AssetManager asset;
	Typeface type;

	Data data = new Data();

	int lastExpandedGroupPosition = 0;
	ExpandableListView listview;

	public ExpandListAdapter(Context context, ArrayList<ExpandListGroup> groups, ExpandableListView listview) {
		this.context = context;
		this.groups = groups;
		this.listview = listview;

	}

	public void addItem(ExpandListChild item, ExpandListGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
		}
		int index = groups.indexOf(group);
		ArrayList<ExpandListChild> ch = groups.get(index).getItems();
		ch.add(item);
		groups.get(index).setItems(ch);
	}
	public Object getChild(int groupPosition, int childPosition) {
		ArrayList<ExpandListChild> chList = groups.get(groupPosition).getItems();
		return chList.get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@SuppressWarnings("static-access")
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
		ExpandListChild child = (ExpandListChild) getChild(groupPosition, childPosition);
		if (view == null) {
			LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = infalInflater.inflate(R.layout.expandlist_child_item, null);
		}

		//ResizeAnimation animation = new ResizeAnimation(view, 1, 370, true);
		//animation.setDuration(1000);
		//view.startAnimation(animation);
		//RelativeLayout rel = (RelativeLayout) view.findViewById(R.id.relativeLayout1);
		//rel.setVisibility(View.VISIBLE);

		final Spinner sp = (Spinner) view.findViewById(R.id.spinner1);

		TextView text1 = (TextView) view.findViewById(R.id.text1);
		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf");
		text1.setTypeface(type);

		final EditText edit = (EditText) view.findViewById(R.id.editText1);
		edit.setTypeface(type);

		Button choose = (Button) view.findViewById(R.id.choose);
		choose.getBackground().setColorFilter(new LightingColorFilter(0xFF8F000B,0xFF8F000B));
		choose.setTypeface(type, 1);
		choose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for(int i = 0; i<data.recipes.size(); i++){
					if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals((data.recipes.get(i)))){
						if(data.recipes.get(i).isPremium == true){
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
							if(edit.getText().toString().equals("0") == false && Integer.parseInt(edit.getText().toString()) <= 20){
								SharedPreferences settings = context.getSharedPreferences("veg", 0);
								String list = settings.getString("list", "");

								list = list + i + "," + edit.getText().toString() + " ";

								SharedPreferences.Editor editor = settings.edit();
								editor.putString("list", list);
								editor.commit();

								Toast.makeText(context, "Recipe added to selection.", Toast.LENGTH_SHORT).show();
							}
							else{
								Toast.makeText(context, "You can only have between 1 and 20 people per recipe. Sorry!", Toast.LENGTH_SHORT).show();
							}
						}
					}

				}
			}
		});

		if(child.getName().equals("Carrots")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Carrots")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Broccoli")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Broccoli")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Cauliflower")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Cauliflower")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Peas")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Peas")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Sweetcorn")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Sweetcorn")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Sprouts")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Sprouts")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Cabbage")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Savoy cabbage")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Potatoes")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Potatoes")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Parsnips")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Parsnips")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Butternut Squash")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Butternut squash")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Fennel")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Fennel")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Sweet Potatoe")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Sweet Potatoe")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Swede")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Swede")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}
		else if(child.getName().equals("Courgette")){
			List<Recipe> list = new ArrayList<Recipe>();

			for(int i = 0; i<data.recipes.size(); i++){
				if(data.recipes.get(i).mainIngre.name.equals("Courgette")){
					list.add(data.recipes.get(i));
				}
			}

			ArrayAdapter<Recipe> aa = new SpinnerAdapter(context, R.layout.spinner_row, list, Integer.parseInt(edit.getText().toString()));
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			sp.setAdapter(aa);
		}

		return view;
	}


	public int getChildrenCount(int groupPosition) {
		ArrayList<ExpandListChild> chList = groups.get(groupPosition).getItems();

		return chList.size();

	}

	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	public int getGroupCount() {
		return groups.size();
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@SuppressWarnings("static-access")
	public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {

		ExpandListGroup group = (ExpandListGroup) getGroup(groupPosition);
		if (view == null) {
			LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			view = inf.inflate(R.layout.expandlist_group_item, null);
		}

		TextView tv = (TextView) view.findViewById(R.id.tvGroup);

		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf"); 
		tv.setTypeface(type, 1);
		tv.setText(group.getName());

		ImageView im = (ImageView) view.findViewById(R.id.imageView1);

		if(group.getName().equals("Carrots")){
			im.setImageResource(R.drawable.carrots);
		}
		else if(group.getName().equals("Brocolli")){
			im.setImageResource(R.drawable.brocolli);
		}
		else if(group.getName().equals("Cauliflower")){
			im.setImageResource(R.drawable.cauliflowers);
		}
		else if(group.getName().equals("Peas")){
			im.setImageResource(R.drawable.peas);
		}
		else if(group.getName().equals("Sweetcorn")){
			im.setImageResource(R.drawable.sweetcorn);
		}
		else if(group.getName().equals("Sprouts")){
			im.setImageResource(R.drawable.sprouts);
		}
		else if(group.getName().equals("Cabbage")){
			im.setImageResource(R.drawable.cabbage);
		}
		else if(group.getName().equals("Potatoes")){
			im.setImageResource(R.drawable.potatoes);
		}
		else if(group.getName().equals("Parsnips")){
			im.setImageResource(R.drawable.parsnips);
		}
		else if(group.getName().equals("Butternut Squash")){
			im.setImageResource(R.drawable.butternutsquash);
		}
		else if(group.getName().equals("Fennel")){
			im.setImageResource(R.drawable.fennel);
		}
		else if(group.getName().equals("Sweet Potatoe")){
			im.setImageResource(R.drawable.sweetpotatoe);
		}
		else if(group.getName().equals("Swede")){
			im.setImageResource(R.drawable.swede);
		}
		else if(group.getName().equals("Courgette")){
			im.setImageResource(R.drawable.courgette);
		}

		return view;
	}

	public boolean hasStableIds() {
		return true;
	}

	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}

	@Override
	public void onGroupExpanded(int groupPosition){
		if(groupPosition != lastExpandedGroupPosition){
			listview.collapseGroup(lastExpandedGroupPosition);
		}

		super.onGroupExpanded(groupPosition);           
		lastExpandedGroupPosition = groupPosition;
	}

	@Override
	public void onGroupCollapsed(int groupPosition){

	}
}

