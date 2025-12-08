package com.election.beans;

import java.sql.Timestamp;

public class TenderAssignmentViewBean {

	private int tenderId;
	private int ownerId;
	private int driverId;
	private Timestamp assignedAt;
	private Timestamp tenderCreation;
	private Timestamp tenderClosed;
	private String tenderStatus;

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public Timestamp getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(Timestamp assignedAt) {
		this.assignedAt = assignedAt;
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

	public String getTenderStatus() {
		return tenderStatus;
	}

	public void setTenderStatus(String tenderStatus) {
		this.tenderStatus = tenderStatus;
	}

}
