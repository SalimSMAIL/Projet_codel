package com.codel.entities;

import java.util.Collection;

public class ContactGroup {
	private long groupId;
	private String groupName;
	private Collection<Contact> contact;
	
	public ContactGroup(long groupId, String groupName, Collection<Contact> contact) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.contact = contact;
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
	public Collection<Contact> getContact() {
		return contact;
	}
	public void setContact(Collection<Contact> contact) {
		this.contact = contact;
	}
	

}
