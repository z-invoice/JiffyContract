package com.nordicusability.jiffy.contract.data;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Small helper class to get user friendly values out of a duration between two times.
 */
public class Duration {

	private long duration;

	/**
	 *
	 * @param start start calendar
	 * @param stop stop calendar
	 */
	public Duration(Calendar start, Calendar stop) {
		duration = stop.getTimeInMillis() - start.getTimeInMillis();
	}

	/**
	 *
	 * @param duration in milliseconds
	 */
	public Duration(long duration) {
		this.duration = duration;
	}

	/**
	 *
	 * @return hours in the format of hours, fractions of hour
	 */
	public float getFractionalHours() {
		return duration / (float) TimeUnit.HOURS.toMillis(1);
	}

	/**
	 *
	 * @return number of full hours
	 */
	public int getHours() {
		return (int) getFractionalHours();
	}

	/**
	 *
	 * @return number of full minutes
	 */
	public int getMinutes() {
		long minutes = duration - getHours() * TimeUnit.HOURS.toMillis(1);
		return (int) (minutes / (float) TimeUnit.MINUTES.toMillis(1));
	}
}
