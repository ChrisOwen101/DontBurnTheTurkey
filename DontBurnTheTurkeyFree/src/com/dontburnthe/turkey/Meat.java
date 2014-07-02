package com.dontburnthe.turkey;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStripNew;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Meat extends SherlockFragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments representing each object in a collection. We use a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter} derivative,
	 * which will destroy and re-create fragments as needed, saving and
	 * restoring their state in the process. This is important to conserve
	 * memory and is a best practice when allowing navigation between objects in
	 * a potentially large collection.
	 */
	static ActionMode mMode;

	CollectionPagerAdapter mCollectionPagerAdapter;
	CollectionPagerAdapter2 mCollectionPagerAdapter2;

	static PagerTitleStripNew titleStrip;
	Context context = this;
	static Animation slidein;
	static Animation setup;
	static Animation slideout;
	static boolean out = false;

	float offset = 0;

	/**
	 * The {@link android.support.v4.view.ViewPager} that will display the
	 * object collection.
	 */
	ViewPager mViewPager;
	ViewPager mViewPager2;

	int currentPos = 0;

	int width;
	int height;
	static Typeface type;

	MenuItem view;
	MenuItem done;

	static float cookingTime = 0;

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meat);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		titleStrip = (PagerTitleStripNew) findViewById(R.id.pager_title_strip);
		titleStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);

		slidein = AnimationUtils.loadAnimation(context, R.anim.slidein);
		slidein.setFillAfter(true);

		slideout = AnimationUtils.loadAnimation(context, R.anim.slideout);
		slideout.setFillAfter(true);

		setup = AnimationUtils.loadAnimation(context, R.anim.setup);
		setup.setFillAfter(true);

		// Create an adapter that when requested, will return a fragment
		// representing an object in
		// the collection.
		//
		// ViewPager and its adapters use support library fragments, so we must
		// use
		// getSupportFragmentManager.
		mCollectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
		mCollectionPagerAdapter2 = new CollectionPagerAdapter2(getSupportFragmentManager());

		type = Typeface.createFromAsset(this.getAssets(),"fonts/coneriascript.ttf"); 

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.actionbar_title, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
		titleTV.setText("Choose Your Main:");
		titleTV.setTypeface(type,1);
		titleTV.setTextSize(16);
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);

		// Set up the ViewPager, attaching the adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager2);
		mViewPager.setAdapter(mCollectionPagerAdapter);

		mViewPager2 = (ViewPager) findViewById(R.id.pager);
		mViewPager2.setAdapter(mCollectionPagerAdapter2);

		Display display = getWindowManager().getDefaultDisplay(); 
		width = display.getWidth();  // deprecated
		height = display.getHeight(); 

		//Very hacky way of making the two viewpagers slide at the same time. A bit buggy when sliding backwards.
		mViewPager2.setOnPageChangeListener(new OnPageChangeListener() {

			public void onPageSelected(int arg0) {

			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
				mViewPager.scrollTo(arg0*width + arg2, 0);
				currentPos = arg0;
			}

			public void onPageScrollStateChanged(int arg0) {
				mViewPager.setCurrentItem(currentPos,false);
			}
		});

		mViewPager.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View arg0, MotionEvent arg1) {
				return true;
			}
		}); 



	}

	/**
	 * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a
	 * fragment representing an object in the collection.
	 */
	public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

		final int NUM_ITEMS = 5; // number of tabs

		public CollectionPagerAdapter(FragmentManager fm) {
			super(fm);
		}


		@Override
		public Fragment getItem(int i) {
			Fragment fragment = new TabFragment();
			Bundle args = new Bundle();
			args.putInt(TabFragment.ARG_OBJECT, i);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			String tabLabel = null;
			switch (position) {
			case 0:
				tabLabel = "Chicken";
				break;
			case 1:
				tabLabel = "Pork";
				break;
			case 2:
				tabLabel = "Turkey";
				break;
			case 3:
				tabLabel = "Beef";
				break;
			case 4:
				tabLabel = "Gammon";
				break;
			}

			return tabLabel;
		}
	}

	//Setup tabs for each of the meats
	public static class TabFragment extends Fragment {

		public static final String ARG_OBJECT = "object";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

			out = false;

			Bundle args = getArguments();
			int position = args.getInt(ARG_OBJECT);

			int tabLayout = 0; 
			switch (position) {
			case 0:
				tabLayout = R.layout.activity_meat_tab1;
				break;
			case 1:
				tabLayout = R.layout.activity_meat_tab2;
				break;
			case 2:
				tabLayout = R.layout.activity_meat_tab3;
				break;
			case 3:
				tabLayout = R.layout.activity_meat_tab5;
				break;
			case 4:
				tabLayout = R.layout.activity_meat_tab4;
				break;
			}

			View rootView = inflater.inflate(tabLayout, container, false);

			ImageView image = (ImageView) rootView.findViewById(R.id.imageView1);


			return rootView;
		}
	}

	public class CollectionPagerAdapter2 extends FragmentStatePagerAdapter {

		final int NUM_ITEMS = 5; // number of tabs

		public CollectionPagerAdapter2(FragmentManager fm) {
			super(fm);
		}


		@Override
		public Fragment getItem(int i) {
			Fragment fragment = new TabFragment2();
			Bundle args = new Bundle();
			args.putInt(TabFragment.ARG_OBJECT, i);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			String tabLabel = null;
			switch (position) {
			case 0:
				tabLabel = "Chicken";
				break;
			case 1:
				tabLabel = "Pork";
				break;
			case 2:
				tabLabel = "Turkey";
				break;
			case 3:
				tabLabel = "Beef";
				break;
			case 4:
				tabLabel = "Gammon";
				break;
			}

			return tabLabel;
		}
	}

	public static class TabFragment2 extends Fragment {

		public static final String ARG_OBJECT = "object";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

			out = false;

			Bundle args = getArguments();
			final int position = args.getInt(ARG_OBJECT);

			int tabLayout = 0; 
			switch (position) {
			case 0:
				tabLayout = R.layout.activity_meat_tab_info1;
				break;
			case 1:
				tabLayout = R.layout.activity_meat_tab_info2;
				break;
			case 2:
				tabLayout = R.layout.activity_meat_tab_info3;
				break;
			case 3:
				tabLayout = R.layout.activity_meat_tab_info5;
				break;
			case 4:
				tabLayout = R.layout.activity_meat_tab_info4;
				break;
			}

			View rootView = inflater.inflate(tabLayout, container, false);

			Button button = (Button) rootView.findViewById(R.id.button1);
			button.setTypeface(type,1);
			button.getBackground().setColorFilter(new LightingColorFilter(0xFF8F000B,0xFF8F000B));

			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {		
					if(cookingTime != 0){
						SharedPreferences settings = getActivity().getSharedPreferences("veg", 0);
						String list = settings.getString("list", "");

						list = list + position + "," + Float.toString(cookingTime) + " ";
						System.out.println(list);
						list = list.substring(0, list.length() - 3);
						list = list + " ";
						System.out.println(list);

						SharedPreferences.Editor editor = settings.edit();
						editor.putString("list", list);
						editor.commit();

						Toast.makeText(getActivity(), "Main added to selection.", Toast.LENGTH_SHORT).show();
					}
				}
			});

			final EditText edit = (EditText) rootView.findViewById(R.id.editText1);
			edit.setTypeface(type);

			String[] weights = {"kg","g","lb","oz"};		
			final Spinner sp = (Spinner) rootView.findViewById(R.id.spinner1);
			WeightSpinnerAdapter spinnerArrayAdapter = new WeightSpinnerAdapter(getActivity(), weights);
			sp.setAdapter(spinnerArrayAdapter);
			sp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
					edit.setText(edit.getText().toString());
				}

				public void onNothingSelected(AdapterView<?> parentView) {}
			});

			final TextView weighttext = (TextView) rootView.findViewById(R.id.textView1);
			weighttext.setTypeface(type);

			final TextView cookingtime = (TextView) rootView.findViewById(R.id.textView2);
			cookingtime.setTypeface(type);

			final TextView time = (TextView) rootView.findViewById(R.id.textView3);
			time.setTypeface(type);

			//Kind of hacky way to calculate the correct weight and time for the meat
			edit.addTextChangedListener(new TextWatcher(){
				public void afterTextChanged(Editable s) {}
				public void beforeTextChanged(CharSequence s, int start, int count, int after){}
				public void onTextChanged(CharSequence s, int start, int before, int count){
					if(count != 0){
						float wieght = Float.parseFloat(s.toString());
						cookingTime = 0;
						if(position == 0){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = (50*wieght)+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = (50*(wieght/1000))+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = (23*wieght)+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = (23*(wieght/16))+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
						}
						if(position == 1){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = (70*wieght)+25;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = (70*(wieght/1000))+25;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = (25*wieght)+25;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = (25*(wieght/16))+25;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
						}
						if(position == 2){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = (32*wieght)+10;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = (32*(wieght/1000))+10;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = (16*wieght)+10;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = (16*(wieght/16))+10;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
						}
						if(position == 3){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = (60*wieght)+30;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = (60*(wieght/1000))+30;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = (30*wieght)+30;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = (30*(wieght/16))+30;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}

						}
						if(position == 4){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = (55*wieght)+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = (55*(wieght/1000))+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = (25*wieght)+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = (25*(wieght/16))+20;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
						}
						if(position == 5){
							if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("kg")){
								cookingTime = 60;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("g")){
								cookingTime = 60;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("lb")){
								cookingTime = 60;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}
							else if(sp.getItemAtPosition(sp.getSelectedItemPosition()).equals("oz")){
								cookingTime = 60;
								time.setText(Float.toString((int)Math.round(cookingTime)) + " minutes");
							}

						}

					}


				}
			}); 


			return rootView;
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
			SharedPreferences settings = getSharedPreferences("firstTime", 0);
			int list = settings.getInt("first", 0);

			if(list == 1){
				Intent intent = new Intent(Meat.this, Main.class);
				startActivity(intent);
			}
			else{
				Intent intent = new Intent(Meat.this, Veg.class);
				startActivity(intent);
			}

		}
		else if(item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

