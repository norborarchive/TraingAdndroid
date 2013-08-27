package com.thjug.hello;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public final class CommentListActivity extends ListActivity {

	private static final String TAG = "CommentListActivity";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylist_commentlist);

        setListAdapter(new CommentAdapter());
    }

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
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

    class CommentAdapter extends ArrayAdapter<String> {

    	CommentAdapter() {
			super(CommentListActivity.this, R.layout.activitylist_commentlistrow);
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }

    }
}
