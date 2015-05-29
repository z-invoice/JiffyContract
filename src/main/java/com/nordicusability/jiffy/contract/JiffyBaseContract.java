package com.nordicusability.jiffy.contract;

import android.net.Uri;

public class JiffyBaseContract {

	private static final String AUTHORITY = "com.nordicusability.jiffy.content";
	public static final String VERSION = "v1";
	public static final String AUTHORITY_V1 = AUTHORITY + '.' + VERSION;

	public static final Uri URI = Uri.parse("content://" + AUTHORITY_V1);

}
