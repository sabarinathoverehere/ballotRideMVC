package com.election.beans;

import java.sql.Timestamp;

public class TenderBean {
	private int tenderId;
	private int locationId;
	private int tenderDistance;
	private String tenderStatus;
	private Timestamp tenderCreation;
	private Timestamp tenderClosed;

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getTenderDistance() {
		return tenderDistance;
	}

	public void setTenderDistance(int tenderDistance) {
		this.tenderDistance = tenderDistance;
	}

	public String getTenderStatus() {
		return tenderStatus;
	}

	public void setTenderStatus(String tenderStatus) {
		this.tenderStatus = tenderStatus;
	}

	public Timestamp getTenderCreation() {
		return tenderCreation;
	}

	public void setTenderCreation(Timestamp tenderCreation) {
		this.tenderCreation = tenderCreation;
	}

	public Timestamp getTenderClosed() {
		return tenderClosed;
	}

	public void setTenderClosed(Timestamp tenderClosed) {
		this.tenderClosed = tenderClosed;
	}

}
