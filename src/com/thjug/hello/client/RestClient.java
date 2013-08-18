package com.thjug.hello.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONObject;

import com.thjug.hello.util.IOUtil;

import android.util.Log;

public class RestClient {

    private static final String TAG = "RestClient";

    private static final int HTTP_STATUS_OK = 200;

    private final String sUserAgent;

    private final HttpClient client;

    public RestClient(final String sUserAgent) {
        this.sUserAgent = sUserAgent;
        client = new DefaultHttpClient();
    }
    
    public InputStream getInputStream(final String url) throws IOException {
    	final HttpGet get = new HttpGet(url);
        get.setHeader("User-Agent", sUserAgent);

        final HttpResponse response = client.execute(get);

        final StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != HTTP_STATUS_OK) {
            throw new IOException("Invalid response from server: " + status.toString()); 
        }

        final HttpEntity entity = response.getEntity();
        
        return entity.getContent();
    }

    public String httpGet(final String url) throws IOException {
        InputStream inputStream = null;
        ByteArrayOutputStream content = null;
        
        try {
        	inputStream = getInputStream(url);
        	content = new ByteArrayOutputStream();
        	
	        int readBytes = 0;
	        byte[] sBuffer = new byte[512];
	        while ((readBytes = inputStream.read(sBuffer)) != -1) {
	            content.write(sBuffer, 0, readBytes); 
	        }
	        
	        final String output = new String(content.toByteArray());
	        Log.i(TAG, output);
	        return output;
        } catch(final IOException e) {
        	throw e;
        } finally {
        	IOUtil.safeclose(content);
        	IOUtil.safeclose(inputStream);
        }
    }
    
    public JSONObject getJsonbyHttpGet(final String url) throws Exception {
        return new JSONObject(httpGet(url));
    }

}
