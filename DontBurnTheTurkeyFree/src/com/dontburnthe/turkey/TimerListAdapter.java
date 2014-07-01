package com.dontburnthe.turkey;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class TimerListAdapter extends ArrayAdapter<ArrayList<Step>> {

	int SECOND_LENGTH = 1000;

	Context context;
	ArrayList<ArrayList<Step>> steps;
	View[] rowViews;
	Calendar[] mustStartTimes;
	int[] remainingTime;
	int[] stepNum;

	boolean on = true;

	TextView[] time;
	TextView[] title;
	TextView[] desc;
	Button[] button;

	String[] currentTitle;
	String[] currentDesc;

	Calendar endTime;
	Calendar startCurrentTime = Calendar.getInstance();

	Handler mHandler;

	boolean isPaused = false;

	Typeface type;

	boolean isFinished = false;

	public TimerListAdapter(Context thread, final ArrayList<ArrayList<Step>> steps, Calendar endTime) {
		super(thread, R.layout.custom_listview_shopping_row, steps);
		this.context = thread;
		this.steps = steps;
		this.endTime = endTime;
		rowViews = new View[steps.size()];
		mustStartTimes = new Calendar[steps.size()];
		remainingTime = new int[steps.size()];

		type = Typeface.createFromAsset(context.getAssets(),"fonts/coneriascript.ttf"); 

		currentTitle = new String[steps.size()];
		currentDesc = new String[steps.size()];

		time = new TextView[steps.size()];
		title = new TextView[steps.size()];
		desc = new TextView[steps.size()];
		button = new Button[steps.size()];

		stepNum = new int[steps.size()];

		for(int i = 0; i<steps.size(); i++){
			stepNum[i] = 0;

			currentTitle[i] = steps.get(i).get(stepNum[i]).title;
			currentDesc[i] = steps.get(i).get(stepNum[i]).desc;
		}

		for(int i = 0; i<steps.size(); i++){
			Calendar hold = Calendar.getInstance();
			hold.set(Calendar.MINUTE, endTime.get(Calendar.MINUTE));
			hold.set(Calendar.HOUR_OF_DAY, endTime.get(Calendar.HOUR_OF_DAY));
			hold.set(Calendar.DAY_OF_MONTH, endTime.get(Calendar.DAY_OF_MONTH));
			hold.set(Calendar.MONTH,endTime.get(Calendar.MONTH));
			hold.set(Calendar.YEAR, endTime.get(Calendar.YEAR));

			System.out.println("Start " + hold.getTime().toString());

			for(int y = 0; y<steps.get(i).size(); y++){
				hold.add(Calendar.MINUTE, -steps.get(i).get(y).time);
			}

			mustStartTimes[i] = Calendar.getInstance();
			mustStartTimes[i].set(Calendar.MINUTE, hold.get(Calendar.MINUTE));
			mustStartTimes[i].set(Calendar.HOUR_OF_DAY, hold.get(Calendar.HOUR_OF_DAY));
			mustStartTimes[i].set(Calendar.DAY_OF_MONTH, hold.get(Calendar.DAY_OF_MONTH));
			mustStartTimes[i].set(Calendar.MONTH, hold.get(Calendar.MONTH));
			mustStartTimes[i].set(Calendar.YEAR, hold.get(Calendar.YEAR)); 

			System.out.println("MUSTSTARTTIME " + mustStartTimes[i].getTime().toString());
		}

		for(int i = 0; i<steps.size(); i++){
			remainingTime[i] = (int) (mustStartTimes[i].getTimeInMillis()/1000 - startCurrentTime.getTimeInMillis()/1000);
		}

		mHandler = new Handler();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(SECOND_LENGTH);
						mHandler.post(new Runnable() {
							public void run() {
								if(isPaused == false){
									for(int i = 0; i<remainingTime.length; i++){
										if(remainingTime[i] == 0){
											stepNum[i]++;
											boolean done = true;

											if(steps.get(i).size() > stepNum[i]){							
												Calendar nextTime = Calendar.getInstance();
												nextTime.add(Calendar.MINUTE, steps.get(i).get(stepNum[i]).time);

												Calendar current = Calendar.getInstance();

												Long difference = nextTime.getTimeInMillis() - current.getTimeInMillis();
												int differenceSec = (int) (difference/1000);
												remainingTime[i] = differenceSec;

												currentDesc[i] = steps.get(i).get(stepNum[i]).desc;
												currentTitle[i] = steps.get(i).get(stepNum[i]).title;
												notifyDataSetChanged();

												makeNotification(currentTitle[i], currentDesc[i], i);
											}

											for(int y = 0; y<remainingTime.length; y++){
												if(remainingTime[y] != 0){
													done = false;
												}
											}

											if(done == true){
												if(isFinished == false){
													isFinished = true;
													Intent intent = new Intent(getContext(), Finished.class);
													intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
													getContext().startActivity(intent);
												}

											}
										}
										else{
											remainingTime[i]--;
											notifyDataSetChanged();
										}
									}       
								}
							}
						});
					} catch (Exception e) {
					}
				}
			}
		}).start();
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		rowViews[position] = convertView;

		if(rowViews[position]==null){
			LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowViews[position]=inflater.inflate(R.layout.custom_timer_row, parent, false);
		}

		title[position] = (TextView) rowViews[position].findViewById(R.id.text);
		title[position].setText(currentTitle[position]);
		title[position].setTypeface(type);

		desc[position] = (TextView) rowViews[position].findViewById(R.id.textView2);
		desc[position].setText(currentDesc[position]);

		time[position] = (TextView) rowViews[position].findViewById(R.id.time);
		time[position].setText(""+formatTime(remainingTime[position]));

		button[position] = (Button) rowViews[position].findViewById(R.id.button1);
		button[position].setText("Done!");
		button[position].getBackground().setColorFilter(new LightingColorFilter(0xFF8F000B,0xFF8F000B));

		button[position].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//if(steps.get(position).size() > stepNum[position]+1){							
				if(steps.get(position).get(stepNum[position]).skipType == 1){
					stepNum[position]++;
					Calendar nextTime = Calendar.getInstance();
					nextTime.add(Calendar.MINUTE, steps.get(position).get(stepNum[position]).time);

					Calendar current = Calendar.getInstance();

					Long difference = nextTime.getTimeInMillis() - current.getTimeInMillis();
					int differenceSec = (int) (difference/1000);
					remainingTime[position] = differenceSec;

					currentDesc[position] = steps.get(position).get(stepNum[position]).desc;
					currentTitle[position] = steps.get(position).get(stepNum[position]).title;
					notifyDataSetChanged();
				}			
				else if(steps.get(position).get(stepNum[position]).skipType == 2){
					DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							switch (which){
							case DialogInterface.BUTTON_POSITIVE:
								stepNum[position]++;
								dialog.dismiss();
								Calendar nextTime = Calendar.getInstance();
								nextTime.add(Calendar.MINUTE, steps.get(position).get(stepNum[position]).time);

								Calendar current = Calendar.getInstance();

								Long difference = nextTime.getTimeInMillis() - current.getTimeInMillis();
								int differenceSec = (int) (difference/1000);
								remainingTime[position] = differenceSec;

								currentDesc[position] = steps.get(position).get(stepNum[position]).desc;
								currentTitle[position] = steps.get(position).get(stepNum[position]).title;
								notifyDataSetChanged();
								break;

							case DialogInterface.BUTTON_NEGATIVE:
								dialog.dismiss();
								break;
							}
						}
					};

					AlertDialog.Builder builder = new AlertDialog.Builder(rowViews[position].getRootView().getContext());
					builder.setTitle("Hang on...");
					builder.setMessage("If you start this recipe now the food may not be at the best at the time that you serve it. We think it would be best if you waited a while before going on to the next step. Do you still want to skip this step?").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();
				}	 
				else if(steps.get(position).get(stepNum[position]).skipType == 3){
					DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							switch (which){
							case DialogInterface.BUTTON_POSITIVE:
								stepNum[position]++;
								dialog.dismiss();
								Calendar nextTime = Calendar.getInstance();
								nextTime.add(Calendar.MINUTE, steps.get(position).get(stepNum[position]).time);

								Calendar current = Calendar.getInstance();

								Long difference = nextTime.getTimeInMillis() - current.getTimeInMillis();
								int differenceSec = (int) (difference/1000);
								remainingTime[position] = differenceSec;

								currentDesc[position] = steps.get(position).get(stepNum[position]).desc;
								currentTitle[position] = steps.get(position).get(stepNum[position]).title;
								notifyDataSetChanged();
								break;

							case DialogInterface.BUTTON_NEGATIVE:
								dialog.dismiss();
								break;
							}
						}
					};

					AlertDialog.Builder builder = new AlertDialog.Builder(rowViews[position].getRootView().getContext());
					builder.setTitle("Wait! Are you sure?");
					builder.setMessage("We think this step of the recipe still has some time to go. You can still skip it if you want but you should check to see if the food is cooked.").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();
				}
				else if(steps.get(position).get(stepNum[position]).skipType == 4){
					currentDesc[position] = "Keep it warm until you are ready to serve...";
					currentTitle[position] = "Recipe Completed!";
					time[position].setVisibility(View.INVISIBLE);
					remainingTime[position] = -1;
					button[position].setEnabled(false);
					notifyDataSetChanged();
				}
				//}
			}
		});

		return rowViews[position];

	}

	public Calendar getTime(){
		Calendar cal = Calendar.getInstance();
		return cal;
	}

	public String formatTime(int secsIn){

		int hours = secsIn / 3600,
				remainder = secsIn % 3600,
				minutes = remainder / 60,
				seconds = remainder % 60;

		return ( (hours < 10 ? "0" : "") + hours
				+ ":" + (minutes < 10 ? "0" : "") + minutes
				+ ":" + (seconds< 10 ? "0" : "") + seconds );
	}

	public void makeNotification(String title, String desc, int id){
		if(on == true){
			MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.ring);
			mp.setOnCompletionListener(new OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {
					mp.release();
				}
			});   
			mp.start();

			Context context = getContext();

			CharSequence contentTitle = title;

			CharSequence contentText = desc;

			final Notification notifyDetails = new Notification(R.drawable.ic_launcher, "Don't Burn The Turkey - " + title, System.currentTimeMillis());

			Intent notifyIntent = new Intent(Intent.ACTION_MAIN);
			notifyIntent.setClass(getContext(), Timer.class);

			PendingIntent intent = PendingIntent.getActivity(context, 0, notifyIntent,  PendingIntent.FLAG_UPDATE_CURRENT | Notification.FLAG_AUTO_CANCEL);

			notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);

			((NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(id, notifyDetails);
		}
	}
}
