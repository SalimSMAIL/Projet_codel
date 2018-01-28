package com.codel.entities;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	
	private long contactId;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Set<ContactGroup> books = new HashSet<>();
	private Set<PhoneNumber> phones = new HashSet<>();
	
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	
	public void addBooks(ContactGroup book){
		books.add(book);
		if(!book.getContacts().contains(this)){
			book.addContact(this);
		}
	}
	
	public void removeBook(ContactGroup book){
		books.remove(book);
		if(book.getContacts().contains(this)){
			book.removeContact(this);
		}
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}
	
	public void addPhone(PhoneNumber phone){
		phones.add(phone);
		if(!phone.getContact().equals(this)){
			phone.setContact(this);
		}
	}
	
	public void removePhone(PhoneNumber phone){
		phones.remove(phone);
	}
	
}
