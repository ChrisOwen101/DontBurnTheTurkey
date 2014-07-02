package com.dontburnthe.turkey;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//Activity appears when all timers have completed.
public class Finished extends Activity {
	
	Typeface type;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_finished);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		type = Typeface.createFromAsset(getAssets(), "fonts/coneriascript.ttf");

		Button button = (Button) findViewById(R.id.button1);
		button.setTypeface(type);
		
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Finished.this, Main.class);
				startActivity(intent);
				
			}
		});
		
		TextView t1 = (TextView) findViewById(R.id.textView2);	
		TextView t2 = (TextView) findViewById(R.id.textView3);	
		TextView t3 = (TextView) findViewById(R.id.textView4);
		TextView title = (TextView) findViewById(R.id.textView1);
		
		t1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Finished.this, Main.class);
				startActivity(intent);
				
			}
		});
		t2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Finished.this, Main.class);
				startActivity(intent);
				
			}
		});
		t3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Finished.this, Main.class);
				startActivity(intent);
				
			}
		});
		
		
		t1.setTypeface(type);
		t2.setTypeface(type);
		t3.setTypeface(type);
		title.setTypeface(type);
		
	}



}
