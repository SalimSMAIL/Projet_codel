package com.codel.entities;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	private long groupId;
	private String groupName;
	private Set<Contact> contacts = new HashSet<>();
	
	public ContactGroup() {
		super();
	}

	public ContactGroup(String groupName) {
		super();
		this.groupName = groupName;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}	
	
	public void addContact(Contact contact){
		contacts.add(contact);
	}
	
	public void removeContact(Contact contact){
		contacts.remove(contact);
		if(contact.getBooks().contains(this)){
			contact.removeBook(this);
		}
	}

}
