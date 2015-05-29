package com.nordicusability.jiffy.contract.data;

import android.app.UiAutomation;
import android.database.Cursor;

import com.nordicusability.jiffy.contract.OwnerContract;

import java.util.Calendar;
import java.util.UUID;

public class Owner {

	UUID uuid;
	String name;
	UUID parentUUID;
	int color;
	boolean archived;
	long lastChanged;
	String rowState;

	public Owner() {
	}

	public Owner(Cursor cursor) {
		setUuid(cursor);
		setParentUuid(cursor);
		setName(cursor);
		setColor(cursor);
		setArchived(cursor);
		setLastChanged(cursor);
		setRowState(cursor);
	}

	private void setUuid(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.UUID);
		if(columnIndex>=0){
			setUuid(UUID.fromString(cursor.getString(columnIndex)));
		}
	}

	private void setParentUuid(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.PARENT_UUID);
		if(columnIndex>=0){
			setParentUUID(UUID.fromString(cursor.getString(columnIndex)));
		}
	}

	private void setName(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.NAME);
		if(columnIndex>=0){
			setName(cursor.getString(columnIndex));
		}
	}

	private void setColor(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.COLOR);
		if(columnIndex>=0){
			setColor(cursor.getInt(columnIndex));
		}
	}

	private void setArchived(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.ARCHIVED);
		if(columnIndex>=0){
			setArchived(cursor.getInt(columnIndex) != 0);
		}
	}

	private void setLastChanged(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.LAST_CHANGED);
		if(columnIndex>=0){
			setLastChanged(cursor.getLong(columnIndex));
		}
	}

	private void setRowState(Cursor cursor) {
		int columnIndex;
		columnIndex = cursor.getColumnIndex(OwnerContract.ROW_STATE);
		if(columnIndex>=0){
			setRowState(cursor.getString(columnIndex));
		}
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public UUID getParentUUID() {
		return parentUUID;
	}

	public void setParentUUID(UUID parentUUID) {
		this.parentUUID = parentUUID;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public long getLastChanged() {
		return lastChanged;
	}

	public void setLastChanged(long lastChanged) {
		this.lastChanged = lastChanged;
	}

	public String getRowState() {
		return rowState;
	}

	public void setRowState(String rowState) {
		this.rowState = rowState;
	}
}
