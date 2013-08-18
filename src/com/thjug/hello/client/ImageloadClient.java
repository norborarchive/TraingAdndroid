package com.thjug.hello.client;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.thjug.hello.util.IOUtil;

public class ImageloadClient {
    private static final String TAG = "ImageloadClient";

    public static Bitmap getBitmap(final String urlstring) {
    	InputStream input = null;

        try {
        	final URL url = new URL(urlstring);
        	final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            input =  connection.getInputStream();
            final Bitmap bit = BitmapFactory.decodeStream(input);
            
            return bit;
        } catch(final Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        } finally {
			IOUtil.safeclose(input);
		}

        return null;
    }
}
