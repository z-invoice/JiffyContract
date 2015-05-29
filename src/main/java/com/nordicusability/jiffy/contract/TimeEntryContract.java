package com.nordicusability.jiffy.contract;

import android.net.Uri;

public final class TimeEntryContract extends JiffyBaseContract {

	//@formatter:off

	private static final String TIME_ENTRIES_AUTHORITY = AUTHORITY_V1 + "/timeEntries";
	//private static final String OWNER_AUTHORITY = AUTHORITY + "/owner";

	public static final Uri TIME_ENTRIES_URI = Uri.parse("content://" + TIME_ENTRIES_AUTHORITY);
	//public static final Uri OWNER_URI = Uri.parse("content://" + OWNER_AUTHORITY);

	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + TIME_ENTRIES_AUTHORITY;
	//public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + OWNER_AUTHORITY;

	/**
	* column name for the UUID column, to be used with the content provider
	 */
	public static final String UUID = "uuid";

	/**
	* column name for the OWNER_UUID column, to be used with the content provider
	 */
	public static final String OWNER_UUID = "owner_uuid";

	/**
	* column name for the START_TIME column, to be used with the content provider
	 */
	public static final String START_TIME = "start_time";

	/**
	* column name for the START_TIME_ZONE column, to be used with the content provider
	 */
	public static final String START_TIME_ZONE = "start_time_zone";

	/**
	* column name for the STOP_TIME column, to be used with the content provider
	 */
	public static final String STOP_TIME = "stop_time";

	/**
	* column name for the STOP_TIME_ZONE column, to be used with the content provider
	 */
	public static final String STOP_TIME_ZONE = "stop_time_zone";

	/**
	* column name for the NOTE column, to be used with the content provider
	 */
	public static final String NOTE = "note";

	/**
	* column name for the LAST_CHANGED column, to be used with the content provider
	 */
	public static final String LAST_CHANGED = "lastChanged";

	/**
	* column name for the ROW_STATE column, to be used with the content provider
	 */
	public static final String ROW_STATE = "rowState";

	public static final String[] ALL_COLUMNS = {UUID, OWNER_UUID, START_TIME, START_TIME_ZONE, STOP_TIME, STOP_TIME_ZONE, LAST_CHANGED, ROW_STATE};

	//@formatter:on

	private TimeEntryContract() {

	}
}
