package com.dontburnthe.turkey;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

//Invite friends to the app -- currently in contruction
public class Invite extends SherlockFragment{

	private Facebook facebook;
	private AsyncFacebookRunner mAsyncRunner;
	String FILENAME = "AndroidSSO_data";
	private SharedPreferences mPrefs;
	LinkedList<String> numbers;
	LinkedList<String> names;
	ListView listView;
	Typeface type;
	ImageView facebookImage;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		numbers = new LinkedList<String>();
		names = new LinkedList<String>();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_invite, container, false);

		facebookImage = (ImageView) view.findViewById(R.id.imageView1);
		listView = (ListView)view.findViewById(R.id.listView);
		listView.setVisibility(View.INVISIBLE);
		
		type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/coneriascript.ttf");
		
		TextView text = (TextView) view.findViewById(R.id.textView1);
		text.setTypeface(type);

		facebookImage.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				login();
			}
		});

		return view;
	}

	//https://play.google.com/store/apps/details?id=com.halfords.android

	public void login(){
		facebook = new Facebook("502496936451802");
		mAsyncRunner = new AsyncFacebookRunner(facebook);

		if (facebook.isSessionValid()) {
			getFriends();
		}
		else {
			facebook.authorize(getActivity(), new String[] {"publish_stream"}, new Facebook.DialogListener() {

				@Override
				public void onFacebookError(FacebookError e) {
					Toast.makeText(getActivity(), "Facebook error: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
				}

				@Override
				public void onError(DialogError e) {
					Toast.makeText(getActivity(), "Facebook dialog error: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
				}

				@Override
				public void onComplete(Bundle values) {
					getFriends();
				}

				@Override
				public void onCancel() {Toast.makeText(getActivity(), "Facebook authorization cancelled.", Toast.LENGTH_LONG).show();

				}
			});
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		facebook.authorizeCallback(requestCode, resultCode, data);
	}

	public void getFriends(){
		Thread t = new Thread(new Runnable() {
			public void run() {
				JSONObject jsonObj;
				try {
					jsonObj = Util.parseJson(facebook.request("me/friends"));

					JSONArray jArray = jsonObj.getJSONArray("data");
					for(int i=0;i<jArray.length();i++){
						JSONObject json_data = jArray.getJSONObject(i);
						Log.v("THIS IS DATA", i+" : "+jArray.getJSONObject(i));
						numbers.add((String) json_data.get("id"));
						names.add((String) json_data.get("name"));
					}
					
					final String[] numbersAr = numbers.toArray(new String[numbers.size()]);
					final String[] namesAr = names.toArray(new String[names.size()]);
					
					sortStringBubble(namesAr, numbersAr);

					getActivity().runOnUiThread(new Runnable() {
						public void run() {
							InviteListAdapter adapter = new InviteListAdapter(getActivity(), namesAr, numbersAr, facebook);  
							listView.setAdapter(adapter);
							listView.setVisibility(View.VISIBLE);
							facebookImage.setVisibility(View.INVISIBLE);
						}
					});

				} catch (FacebookError e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();

	}

	public static void sortStringBubble(String[] x, String[] y)
	{
		int j;
		boolean flag = true;  // will determine when the sort is finished
		String temp;

		while ( flag )
		{
			flag = false;
			for ( j = 0;  j < x.length - 1;  j++ )
			{
				if ( x [ j ].compareToIgnoreCase( x [ j+1 ] ) > 0 )
				{                                             // ascending sort
					temp = x [ j ];
					x [ j ] = x [ j+1];     // swapping
					x [ j+1] = temp;
					
					temp = y [ j ];
					y [ j ] = y [ j+1];     // swapping
					y [ j+1] = temp;
					
					
					flag = true;
				}
			}
		}
	} 
}
