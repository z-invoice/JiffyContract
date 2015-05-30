package com.nordicusability.jiffy.contract.data;

import android.database.Cursor;

import com.nordicusability.jiffy.contract.OwnerContract;
import com.nordicusability.jiffy.contract.TimeEntryContract;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Holder for the time entries that Jiffy uses to store the data.
 */
public class TimeEntry {

	private UUID uuid;
	private UUID ownerUuid;
	private Calendar startTime = Calendar.getInstance();
	private Calendar stopTime = Calendar.getInstance();
	private String note;
	private long lastChanged;
	private String rowState;


	/**
	 * Default constructor
	 */
	public TimeEntry() {
	}

	/**
	 * Constructor from cursor.
	 * It will not advance to next position in the cursor, that must be done outside
	 * @param cursor a cursor from Jiffy content provider.
	 */
	public TimeEntry(Cursor cursor) {
		setUuid(cursor);
		setOwnerUuid(cursor);
		setStartTime(cursor);
		setStartTimeZone(cursor);
		setStopTime(cursor);
		setStopTimeZone(cursor);
		setNote(cursor);
		setLastChanged(cursor);
		setRowState(cursor);
	}

	private void setUuid(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.UUID);
		if (columnIndex >= 0) {
			setUuid(UUID.fromString(cursor.getString(columnIndex)));
		}
	}

	private void setOwnerUuid(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.OWNER_UUID);
		if (columnIndex >= 0) {
			setOwnerUuid(UUID.fromString(cursor.getString(columnIndex)));
		}
	}

	private void setStartTime(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.START_TIME);
		if (columnIndex >= 0) {
			startTime.setTimeInMillis(cursor.getLong(columnIndex));
		}
	}

	private void setStartTimeZone(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.START_TIME_ZONE);
		if (columnIndex >= 0) {
			startTime.setTimeZone(TimeZone.getTimeZone(cursor.getString(columnIndex)));
		}
	}

	private void setStopTime(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.STOP_TIME);
		if (columnIndex >= 0) {
			stopTime.setTimeInMillis(cursor.getLong(columnIndex));
		}
	}

	private void setStopTimeZone(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.STOP_TIME_ZONE);
		if (columnIndex >= 0) {
			stopTime.setTimeZone(TimeZone.getTimeZone(cursor.getString(columnIndex)));
		}
	}

	private void setNote(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(TimeEntryContract.NOTE);
		if (columnIndex >= 0) {
			setNote(cursor.getString(columnIndex));
		}
	}

	private void setLastChanged(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.LAST_CHANGED);
		if (columnIndex >= 0) {
			setLastChanged(cursor.getLong(columnIndex));
		}
	}

	private void setRowState(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.ROW_STATE);
		if (columnIndex >= 0) {
			setRowState(cursor.getString(columnIndex));
		}
	}

	/**
	 *
	 * @return the UUID of the item
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 *
	 * @param uuid a UUID to identify this item
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 *
	 * @return the UUID for the owner of this time {@link Owner}
	 */
	public UUID getOwnerUuid() {
		return ownerUuid;
	}

	/**
	 *
	 * @param ownerUuid the UUID for the owner of this time {@link Owner}
	 */
	public void setOwnerUuid(UUID ownerUuid) {
		this.ownerUuid = ownerUuid;
	}

	/**
	 *
	 * @return a calendar object for start time of this entry
	 */
	public Calendar getStartTime() {
		return startTime;
	}

	/**
	 *
	 * @param startTime sets a new start time for this entry
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 *
	 * @return the {@link TimeZone} for this entries start time
	 */
	public TimeZone getStartTimeZone() {
		return startTime.getTimeZone();
	}

	/**
	 *
	 * @param startTimeZone set a new start time zone for this time.
	 */
	public void setStartTimeZone(TimeZone startTimeZone) {
		this.startTime.setTimeZone(startTimeZone);
	}

	/**
	 *
	 * @return the stop time for this entry, or now if the time is currently running)
	 */
	public Calendar getStopTime() {
		if(isRunning()){
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(stopTime.getTimeZone());
			return calendar;
		} else {
			return stopTime;
		}
	}

	/**
	 *
	 * @param stopTime sets a new stop time for this entry. Set a calendar with time in milliseconds = -1 to make it running
	 */
	public void setStopTime(Calendar stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 *
	 * @return the {@link TimeZone} for this entries stop time
	 */
	public TimeZone getStopTimeZone() {
		return stopTime.getTimeZone();
	}

	/**
	 *
	 * @param stopTimeZone set a new stop time zone for this time.
	 */
	public void setStopTimeZone(TimeZone stopTimeZone) {
		this.stopTime.setTimeZone(stopTimeZone);
	}

	/**
	 *
	 * @return true if this time is currently running.
	 */
	public boolean isRunning(){
		return stopTime.getTimeInMillis()<0;
	}

	/**
	 *
	 * @return a {@link Duration} object for this time. If its running, it duration will be locked within this object. Request it again to get an updated duration
	 */
	public Duration getDuration(){
		return new Duration(getStartTime(), getStopTime());
	}

	/**
	 *
	 * @return a textual note for the entry
	 */
	public String getNote() {
		return note;
	}

	/**
	 *
	 * @param note set a new note for this entry
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 *
	 * @return last changed in epoc milliseconds
	 */
	public long getLastChanged() {
		return lastChanged;
	}

	/**
	 *
	 * @param lastChanged set new last changed in epoc milliseconds
	 */
	public void setLastChanged(long lastChanged) {
		this.lastChanged = lastChanged;
	}

	/**
	 *
	 * @return the state of the row, its either 'active' or 'deleted'
	 */
	public String getRowState() {
		return rowState;
	}

	/**
	 *
	 * @param rowState set a new row state for this entry
	 */
	public void setRowState(String rowState) {
		this.rowState = rowState;
	}
}
