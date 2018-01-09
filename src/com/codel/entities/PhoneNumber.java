package com.codel.entities;

public class PhoneNumber {
	
	private long phoneId;
	private String phoneNumber;
	private String phoneKind;
	
	private Contact contact;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(long phoneId, String phoneNumber, String phoneKind, Contact contact) {
		super();
		this.phoneId = phoneId;
		this.phoneNumber = phoneNumber;
		this.phoneKind = phoneKind;
		this.contact = contact;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
}
