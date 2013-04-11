package edu.wctc.android.calendardisplay.adapter;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class CalendarCursorAdapter extends SimpleCursorAdapter {

	public CalendarCursorAdapter(Context context, int layout, Cursor c,
			String[] from, int[] to, int flags) {
		super(context, layout, c, from, to, flags);
	}

	public static String getDate(Long milliSeconds, String dateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.US);
		return formatter.format(milliSeconds);
	}

	@Override
	public void setViewText(TextView v, String text) {
		if (v.getId() == android.R.id.text1) {
			// Make sure it matches your time field
			// You may want to try/catch with NumberFormatException in case
			// `text` is not a numeric value
			text = getDate(Long.parseLong(text), "dd. MMMM yyyy hh:mm:ss");
		}
		v.setText(text);
	}

}