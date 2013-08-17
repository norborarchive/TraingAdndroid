package com.thjug.hello;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(final Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);        
        try {
            getClass().getMethod("getFragmentManager");
            AddResourceApi11AndGreater();
        } catch (final NoSuchMethodException e) {
            AddResourceApiLessThan11();
        }
    }
 
    @SuppressWarnings("deprecation")
    protected void AddResourceApiLessThan11() {
        addPreferencesFromResource(R.xml.preference);
    }

    @TargetApi(11)
    protected void AddResourceApi11AndGreater() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PF()).commit();
    }

    @TargetApi(11)
    public static class PF extends PreferenceFragment {       
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
        }
    }
}
