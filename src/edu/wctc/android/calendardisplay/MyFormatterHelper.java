package edu.wctc.android.calendardisplay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;

public class MyFormatterHelper {

	public static String formatDate(Context applicationContext, long millis) {
		SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm",
				Locale.US);
		return format.format(new Date(millis));
	}
}
