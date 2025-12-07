package com.election.beans;

import java.sql.Timestamp;

public class TenderAssignments {
	
	private int tenderAssignmentId;
	private int tenderId;
	private int ownerId;
	private int driverId;
	private Timestamp assignTime;
	private Timestamp completedTime;

	public int getTenderAssignmentId() {
		return tenderAssignmentId;
	}

	public void setTenderAssignmentId(int tenderAssignmentId) {
		this.tenderAssignmentId = tenderAssignmentId;
	}

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

	public Timestamp getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Timestamp assignTime) {
		this.assignTime = assignTime;
	}

	public Timestamp getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Timestamp completedTime) {
		this.completedTime = completedTime;
	}
	
	

}
