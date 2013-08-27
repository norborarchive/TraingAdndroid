package com.thjug.hello;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class WebActivity extends Activity {

	private static final String TAG = "WebActivity";

    private WebView mWebView;

	@Override
	@SuppressLint("SetJavaScriptEnabled")
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_web);

        try {
        	mWebView = (WebView) findViewById(R.id.webview);
            mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

            final WebSettings webSettings = mWebView.getSettings();
            webSettings.setSavePassword(false);
            webSettings.setSaveFormData(false);
            webSettings.setSupportZoom(false);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);

            mWebView.loadUrl("https://m.facebook.com/groups/thjug"); }
        catch (final Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

    }

}
