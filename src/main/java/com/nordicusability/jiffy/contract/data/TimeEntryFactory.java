package com.nordicusability.jiffy.contract.data;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class TimeEntryFactory {

	public static List<TimeEntry> convert(Cursor cursor) {
		List<TimeEntry> result = new ArrayList<>();
		while (cursor.moveToNext()) {
			result.add(new TimeEntry(cursor));
		}
		return result;
	}

}


