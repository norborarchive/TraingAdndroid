package com.thjug.hello;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public final class HelloListActivity extends ListActivity {

	private static final String TAG = "HelloListActivity";

	private static String [] no = new String[] {
			 "0894446110"
			,"0894446110"
			,"0894446110"
			,"0894446110"
			,"0894446110" };

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylist_hellolist);

        setListAdapter(new HelloAdapter());
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
	        	finish();
	            return true;
            default:
            	return super.onOptionsItemSelected(item);
	    }
	}

    @Override
    public void onListItemClick(final ListView parent, final View v, final int position, final long id) {
        try {
        	final TextView t = (TextView) v.findViewById(R.id.hellowlist_name);
        	Toast.makeText(getApplicationContext(), "Hello " + t.getText(), Toast.LENGTH_SHORT).show();

        	// Call
        	final Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + no[position]));
            startActivity(callIntent);
        } catch(final Exception e) {
        	Log.e(TAG, e.getMessage(), e);
        }
    }

    class HelloAdapter extends ArrayAdapter<String> {

    	HelloAdapter() {
            super(HelloListActivity.this, R.layout.activitylist_hellolistrow, R.id.hellowlist_name
            		, new String[] {
            			 "Petdo."
            			,"Norbor."
            			,"Peerapat."
            			,"Nuboat."
            			,"Duke"
            });
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }

    }
}
