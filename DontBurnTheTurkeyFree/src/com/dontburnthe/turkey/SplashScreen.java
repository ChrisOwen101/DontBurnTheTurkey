package com.dontburnthe.turkey;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends Activity {

	int list = -1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		SharedPreferences settings = getSharedPreferences("firstTime", 0);
		list = settings.getInt("first", 0);
		
		TextView text = (TextView) findViewById(R.id.textView1);
		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/coneriascript.ttf");
		text.setTypeface(type,1);
		
		Handler handler = new Handler();

		// run a thread after 2 seconds to start the home screen
		handler.postDelayed(new Runnable() {

			public void run() {
				if(list == 0){
					finish();
					startActivity(new Intent(getApplicationContext(), Intro.class));
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				}
				else{
					finish();
					startActivity(new Intent(getApplicationContext(), Main.class));
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				}

			}

		},1000); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
	}



}
