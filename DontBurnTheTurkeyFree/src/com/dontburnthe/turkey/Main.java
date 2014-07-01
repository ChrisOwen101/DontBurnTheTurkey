package com.dontburnthe.turkey;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;


public class Main extends SherlockFragmentActivity
{

	ViewPager mViewPager;
	TabsAdapter mTabsAdapter;
	TextView tabCenter;
	TextView tabText;
	Context context = this;
	Typeface type;
	String[] tabNames = {"Review","Shopping List","Invite"};
	
	Data data = new Data();
	
	LinkedList<Recipe> recipes = new LinkedList<Recipe>();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		type = Typeface.createFromAsset(getAssets(), "fonts/coneriascript.ttf");


		mViewPager = (ViewPager) findViewById(R.id.pager);

		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		bar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.actionbar_title, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
		titleTV.setText("Don't Burn The Turkey");
		titleTV.setTypeface(type,1);
		bar.setCustomView(customView);
		bar.setDisplayShowCustomEnabled(true);
		

		mTabsAdapter = new TabsAdapter(this, mViewPager);
		
		mTabsAdapter.addTab(bar.newTab().setText("Review"), Review.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Shopping List"), ShoppingList.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Invite"), Invite.class, null);
		
		for(int i = 0; i<bar.getTabCount(); i++){
			inflater = LayoutInflater.from(this);
			customView = inflater.inflate(R.layout.tab_title, null);

			titleTV = (TextView) customView.findViewById(R.id.action_custom_title);
			titleTV.setText(tabNames[i]);
			titleTV.setTypeface(type);

			bar.getTabAt(i).setCustomView(customView);
		}

		Button button = (Button) findViewById(R.id.button1);
		button.setTypeface(type);
		button.setTextColor(Color.WHITE);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {	
				TimeSelectDialog dialog = new TimeSelectDialog(context);
				dialog.show();
			}
		});

	}

	public static class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener, ViewPager.OnPageChangeListener
	{
		private final Context mContext;
		private final ActionBar mActionBar;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		static final class TabInfo
		{
			private final Class<?> clss;
			private final Bundle args;

			TabInfo(Class<?> _class, Bundle _args)
			{
				clss = _class;
				args = _args;
			}
		}

		public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager)
		{
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mActionBar = activity.getSupportActionBar();
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args)
		{
			TabInfo info = new TabInfo(clss, args);
			tab.setTag(info);
			tab.setTabListener(this);
			mTabs.add(info);
			mActionBar.addTab(tab);
			notifyDataSetChanged();
		}

		@Override
		public int getCount()
		{
			return mTabs.size();
		}

		@Override
		public Fragment getItem(int position)
		{
			TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clss.getName(),
					info.args);
		}

		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels)
		{
		}

		public void onPageSelected(int position)
		{
			mActionBar.setSelectedNavigationItem(position);
		}

		public void onPageScrollStateChanged(int state)
		{
		}

		public void onTabSelected(Tab tab, FragmentTransaction ft)
		{
			Object tag = tab.getTag();
			for (int i = 0; i < mTabs.size(); i++)
			{
				if (mTabs.get(i) == tag)
				{
					mViewPager.setCurrentItem(i);
				}
			}
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft)
		{
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft)
		{
		}
	}
}