package com.dontburnthe.turkey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

public class InviteListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final Facebook facebook;
	private final String[] names;
	private final String[] numPeople;
	private final View[] rowViews;
	Typeface type;
	LinkedList<String> invitedNum = new LinkedList<String>();
	LinkedList<String> invitedPeople = new LinkedList<String>();

	public InviteListAdapter(Context thread, String[] names,String[] numPeople, Facebook facebook) {
		super(thread, R.layout.custom_listview_invite_row, names);
		this.context = thread;
		this.names = names;
		this.facebook = facebook;
		rowViews = new View[names.length];
		this.numPeople = numPeople;
		type = Typeface.createFromAsset(context.getAssets(), "fonts/coneriascript.ttf");

	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		notifyDataSetChanged();
		rowViews[position] = convertView;

		if(rowViews[position]==null){
			LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowViews[position]=inflater.inflate(R.layout.custom_listview_invite_row, parent, false);
		}

		TextView textView = (TextView) rowViews[position].findViewById(R.id.item);
		textView.setText(names[position]);
		textView.setTypeface(type);

		Button invite = (Button) rowViews[position].findViewById(R.id.button);
		invite.setTypeface(type);

		invite.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				invitedPeople.add(names[position]);
				invitedNum.add(numPeople[position]);
				postOnFacebookPicture();
			}
		});

		return rowViews[position];

	}

	public void postOnFacebookPicture() {
		String dataMsg = "Dear ";

		for(int i = 0; i<invitedPeople.size(); i++){
			if(i == invitedPeople.size()-1){
				String arr[] = invitedPeople.get(i).split(" ",2);
				dataMsg = dataMsg + arr[0] + ",\n";
			}
			else{
				String arr[] = invitedPeople.get(i).split(" ",2);
				dataMsg = dataMsg + arr[0] + ", ";
			}

		}

		dataMsg = dataMsg + "@[Ziggy Bracey:1:718755363]";

		//Bundle param;

		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.promo);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte[] data = stream.toByteArray();

		/**AsyncFacebookRunner mAsyncRunner = new AsyncFacebookRunner(facebook);
		param = new Bundle();
		param.putString("message", dataMsg);
		param.putString("place","House");
		param.putString("tags","718755363");
		param.putString("filename", "Invite");
		param.putByteArray("picture", data);
		mAsyncRunner.request("me/photos", param, "POST", new SampleUploadListener(), null);**/

		Thread t = new Thread(new Runnable() {	
			public void run() {
				Bundle param = new Bundle();
				param.putString("message", "Hello");
				param.putString("place","House");
				param.putString("tags","718755363");
				try {
					String response = facebook.request("me/feed", param,"POST");
					System.out.println(response);

					
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		t.start();



	}

	public class SampleUploadListener extends BaseRequestListener {

		public void onComplete(final String response, final Object state) {
			try {
				// process the response here: (executed in background thread)
				Log.d("Facebook-Example", "Response: " + response.toString());
				JSONObject json = Util.parseJson(response);
				final String src = json.getString("src");

				// then post the processed result back to the UI thread
				// if we do not do this, an runtime exception will be generated
				// e.g. "CalledFromWrongThreadException: Only the original
				// thread that created a view hierarchy can touch its views."

			} catch (JSONException e) {
				Log.w("Facebook-Example", "JSON Error in response");
			} catch (FacebookError e) {
				Log.w("Facebook-Example", "Facebook Error: " + e.getMessage());
			}
		}
	}
}
