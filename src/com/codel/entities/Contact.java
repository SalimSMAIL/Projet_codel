package com.codel.entities;

import java.util.Collection;

public class Contact {
	
	//pk ya pas de password .... ??
	private long contact_id;
	private String firstname;
	private String lastname;
	private String email;
	private Adress adress;
	private Collection<ContactGroup> contactGroup;
	private Collection<PhoneNumber> phoneNumber;
	

	public Collection<ContactGroup> getContactGroup() {
		return contactGroup;
	}
	public void setContactGroup(Collection<ContactGroup> contactGroup) {
		this.contactGroup = contactGroup;
	}
	public Collection<PhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Collection<PhoneNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getContact_id() {
		return contact_id;
	}
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
