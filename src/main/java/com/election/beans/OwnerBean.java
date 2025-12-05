package com.election.beans;

public class OwnerBean {
	
	private int oId;
	private int userId;
	private String oName;
	private String oAddress;
	private String oContact;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getoContact() {
		return oContact;
	}

	public void setoContact(String oContact) {
		this.oContact = oContact;
	}

}
