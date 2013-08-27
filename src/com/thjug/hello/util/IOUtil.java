package com.thjug.hello.util;

import java.io.Closeable;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

public final class IOUtil {

	private static final String TAG = "IOUtil";

	private IOUtil() {}

	public static boolean fileexist(final String fullname) throws IOException {
		final File file = new File(fullname);

		return (file.exists() && file.length() != 0) ? true : false;
    }

	public static Bitmap getfile(final String fullname) throws IOException {
		if (fileexist(fullname)) {
			return BitmapFactory.decodeFile(fullname);
		} else {
			return null;
		}
    }

	public static void save(final Bitmap bit, final String filename) throws IOException {
		FileOutputStream fout = null;

        try {
    		final String filepath = Environment.getExternalStorageDirectory().getAbsolutePath();

			fout = new FileOutputStream(new File(filepath + "/" + filename));
			bit.compress(CompressFormat.PNG, 100, fout);
			fout.flush();
        } finally {
        	safeclose(fout);
		}
	}

	public static void safeclose(final Closeable c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch(final IOException e) {
			Log.e(TAG, e.getMessage(), e);
		}
	}

}
