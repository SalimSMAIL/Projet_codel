package com.codel.daos.interfaces;

import java.util.List;

import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;

public interface IContactGroupDAO extends IDAO<ContactGroup>{

	List<Contact> getContacts(long idGroup);

}
