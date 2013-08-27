package com.thjug.hello;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.TextView;

public final class ShowPreferenceActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showpreference);

		final SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

		final StringBuilder builder = new StringBuilder();
		builder.append("\n" + sharedPrefs.getBoolean("perform_updates",		false));
		builder.append("\n" + sharedPrefs.getString( "updates_interval",	"-1"));
		builder.append("\n" + sharedPrefs.getString( "welcome_message", 	"NULL"));

		final TextView settingsTextView = (TextView) findViewById(R.id.lblPreference);

		settingsTextView.setText(builder.toString());
	}

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

}
