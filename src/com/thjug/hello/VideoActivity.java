package com.thjug.hello;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		String path = "http://192.168.176.129:8383/Video/kitty.mp4";

	    final Uri uri = Uri.parse(path);

	    final VideoView video = (VideoView) findViewById(R.id.videoview);
	    video.setVideoURI(uri);
	    video.start();
	}

}
