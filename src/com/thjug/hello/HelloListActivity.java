package com.thjug.hello;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HelloListActivity extends ListActivity {
	
	private static final String TAG = "HelloListActivity";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylist_hellolist);

        setListAdapter(new HelloAdapter());
    }
    
    @Override
    public void onListItemClick(final ListView parent, final View v, final int position, final long id) {
        try {
        	final TextView t = (TextView) v.findViewById(R.id.hellowlist_name);
        	Toast.makeText(getApplicationContext(), "Hello " + t.getText(), Toast.LENGTH_SHORT).show();
        } catch(final Exception e) {
        	Log.e(TAG, e.getMessage(), e);
        }

    }
    
    class HelloAdapter extends ArrayAdapter<String> {

    	HelloAdapter() {
            super(HelloListActivity.this, R.layout.activitylistrow_hellolist, R.id.hellowlist_name
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
            View row = super.getView(position, convertView, parent);
            return row;
        }

    }
}
