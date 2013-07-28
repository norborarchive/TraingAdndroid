package com.thjug.hello;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btnHello).setOnClickListener(btnHelloClick);
		findViewById(R.id.btnFill).setOnClickListener(btnFillClick);
		///findViewById(R.id.txtHello).setOnKeyListener(txtKey);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	startActivity(new Intent(this, SettingsActivity.class));
	            return true;
	        case R.id.action_showsetting:
	        	startActivity(new Intent(this, ShowPreferenceActivity.class));
	            return true;
	        case R.id.action_about:
	        	Toast.makeText(getApplicationContext(), "About Clicked !", Toast.LENGTH_SHORT).show();
	            return true;
            default:
            	return super.onOptionsItemSelected(item);
	    }
	}
	
	final OnClickListener btnHelloClick = new OnClickListener() {
		@Override
		public void onClick(final View v) {
	    	Toast.makeText(getApplicationContext(), "Hello World !", Toast.LENGTH_SHORT).show();
	    	
			final TextView lbl = (TextView) findViewById(R.id.lblHello);
			lbl.setText(R.string.hello_norbor);			
		}
	};
	
	final OnClickListener btnFillClick = new OnClickListener() {
		@Override
		public void onClick(final View v) {
			final EditText txt = (EditText) findViewById(R.id.txtHello);
			txt.setText(R.string.hello_norbor);			
		}
	};
	
	final OnKeyListener txtKey = new OnKeyListener() {
		
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			//Toast.makeText(getApplicationContext(), ""+keyCode, Toast.LENGTH_SHORT).show();
			return true;
		}
	};

}
