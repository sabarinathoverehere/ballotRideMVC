package com.election.beans;

import java.sql.Timestamp;

public class PaymentBean {

	private int paymentId;
	private int tenderId;
	private int ownerId;
	private double amount;
	private String status;
	private Timestamp paidAt;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Timestamp paidAt) {
		this.paidAt = paidAt;
	}

}
