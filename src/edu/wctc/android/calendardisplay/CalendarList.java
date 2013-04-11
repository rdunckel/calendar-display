package edu.wctc.android.calendardisplay;

import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.ViewBinder;
import android.widget.TextView;

public class CalendarList extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		CursorLoader calendarLoader = new CursorLoader(this,
				CalendarContract.Events.CONTENT_URI, null, null, null, null);

		Cursor calendar = calendarLoader.loadInBackground();

		SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
				android.R.layout.two_line_list_item, calendar, new String[] {
						CalendarContract.Events.DESCRIPTION,
						CalendarContract.Events.DTSTART }, new int[] {
						android.R.id.text1, android.R.id.text2 }, 0);

		listAdapter.setViewBinder(new ViewBinder() {
			@Override
			public boolean setViewValue(View view, Cursor cursor,
					int columnIndex) {
				if (columnIndex == cursor
						.getColumnIndex(CalendarContract.Events.DTSTART)) {
					long date = cursor.getLong(columnIndex);
					TextView textView = (TextView) view;
					textView.setText(MyFormatterHelper.formatDate(
							getApplicationContext(), date));
					return true;
				}

				return false;
			}
		});

		setListAdapter(listAdapter);
	}
}
