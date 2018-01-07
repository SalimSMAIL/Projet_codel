package com.codel.entities;

import java.util.Set;

public class Contact {
	
	private long contactId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Address address;
	private Set<ContactGroup> books;
//	private Set<PhoneNumber> phones;
	
	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName, String email, String password, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(Set<ContactGroup> books) {
		this.books = books;
	}

//	public Set<PhoneNumber> getPhones() {
//		return phones;
//	}
//
//	public void setPhones(Set<PhoneNumber> phones) {
//		this.phones = phones;
//	}
	


	
	
}
