package com.thjug.hello;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class PetWidget extends AppWidgetProvider {

	public static final String BTN_READFULLSTORY = "READFULLSTORY";

	@Override
	public void onEnabled(final Context context) {
		super.onEnabled(context);
		
		final String url = "http://www.iampetdo.com";
		final Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		final PendingIntent pintent = PendingIntent.getActivity(context, 0, intent, 0);
		
		final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_petdo);
		views.setOnClickPendingIntent(R.id.btnRead, pintent);
		
		final ComponentName thisWidget = new ComponentName(context, PetWidget.class);
		final AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thisWidget, views);
	}

	@Override
	public void onUpdate(final Context context,
			final AppWidgetManager appWidgetManager, final int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	@Override
	public void onReceive(final Context context, final Intent intent) {
		super.onReceive(context, intent);
	}
}
