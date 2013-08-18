package com.thjug.hello;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thjug.hello.client.ImageloadClient;

public class BitmapActivity extends Activity {
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitmap);
		
		findViewById(R.id.button1).setOnClickListener(btnClick);
		findViewById(R.id.button2).setOnClickListener(btnClick);
		findViewById(R.id.button3).setOnClickListener(btnClick);
		findViewById(R.id.button4).setOnClickListener(btnClick);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_about:
	        	Toast.makeText(getApplicationContext(), "About Clicked !", Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.action_exit:
	        	System.exit(0);
	            return true;
            default:
            	return super.onOptionsItemSelected(item);
	    }
	}
	
	public void updateImage(final Bitmap bitmap) {
		final ImageView image = (ImageView) findViewById(R.id.petdoimage);
		image.setImageBitmap(bitmap);
	}
	
	final OnClickListener btnClick = new OnClickListener() {
		@Override
		public void onClick(final View v) {
			final Button text = (Button) v;
			
			String url;
			switch (Integer.parseInt(text.getText().toString().trim())) {
				case 1:
					url = "http://iampetdo.com/sites/default/files/imagecache/comic_node/ep78_1.png";
					break;
				case 2:
					url = "http://iampetdo.com/sites/default/files/imagecache/comic_node/ep78_2_0.png";
					break;
				case 3:
					url = "http://iampetdo.com/sites/default/files/imagecache/comic_node/ep78_3_1.png";
					break;
				case 4:
					url = "http://iampetdo.com/sites/default/files/imagecache/comic_node/ep78_4_2_0.png";
					break;
				default:
					url = "http://iampetdo.com/sites/default/files/imagecache/comic_node/ep78_1.png";
							
			}
			
			new RetreiveElevationTask().execute(url);
		}
	};
	
	final OnClickListener btnFillClick = new OnClickListener() {
		@Override
		public void onClick(final View v) {
			final EditText txt = (EditText) findViewById(R.id.txtHello);
			txt.setText(R.string.hello_norbor);			
		}
	}; 
	
	class RetreiveElevationTask extends AsyncTask<String, Void, Bitmap> {
		
	    private static final String TAG = "RetreiveElevationTask";
	    
	    protected Bitmap doInBackground(final String... urls) {
	    	Log.d(TAG, "doInBackground");
	        try {
	        	return ImageloadClient.getBitmap(urls[0]); 
	        } catch (final Exception e) {
	            Log.e(TAG, e.getMessage(), e);
	            return null;
	        }
	    }

	    protected void onPostExecute(final Bitmap bitmap) {
	    	Log.d(TAG, "onPostExecute");
	    	updateImage(bitmap);
	    }
	}

}
