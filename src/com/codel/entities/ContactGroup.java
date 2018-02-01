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

	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
	public void removeAllContacts(){
		contacts.clear();
	}
	
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof ContactGroup) ) return false;

        final ContactGroup contactGroup = (ContactGroup) other;

        if ( contactGroup.getGroupId()!=getGroupId() ) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = getGroupName().hashCode();
        result = (int) (29 * result + getGroupId());
        return result;
    }

}
