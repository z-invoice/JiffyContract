package com.nordicusability.jiffy.contract;

import android.net.Uri;

public final class OwnerContract extends JiffyBaseContract {

	//@formatter:off


	private static final String OWNERS_AUTHORITY = AUTHORITY_V1 + "/owners";
	private static final String OWNER_AUTHORITY = AUTHORITY_V1 + "/owner";

	public static final Uri OWNERS_URI = Uri.parse("content://" + OWNERS_AUTHORITY);
	public static final Uri OWNER_URI = Uri.parse("content://" + OWNER_AUTHORITY);

	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + OWNERS_AUTHORITY;
	public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + OWNER_AUTHORITY;

	/**
	* column name for the UUID column, to be used with the content provider
	 */
	public static final String UUID = "uuid";
	/**
	* column name for the PARENT_UUID column, to be used with the content provider
	 */
	public static final String PARENT_UUID = "parent_uuid";
	/**
	* column name for the NAME column, to be used with the content provider
	 */
	public static final String NAME = "name";
	/**
	* column name for the COLOR column, to be used with the content provider
	 */
	public static final String COLOR = "color";
	/**
	* column name for the ARCHIVED column, to be used with the content provider
	 */
	public static final String ARCHIVED = "archived";
	/**
	* column name for the LAST_CHANGED column, to be used with the content provider
	 */
	public static final String LAST_CHANGED = "lastChanged";
	/**
	* column name for the ROW_STATE column, to be used with the content provider
	 */
	public static final String ROW_STATE = "rowState";

	/**
	* All columns to be used with the content provider as projection variable
	 */
	public static final String[] ALL_COLUMNS = {UUID, PARENT_UUID, NAME, COLOR, ARCHIVED, LAST_CHANGED, ROW_STATE};

	//@formatter:on

	private OwnerContract() {

	}
}
