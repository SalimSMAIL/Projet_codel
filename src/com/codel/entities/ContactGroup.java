package com.codel.entities;

import java.util.Set;

public class ContactGroup {
	private long groupId;
	private String groupName;
	private Set<Contact> contacts;
	
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

}
