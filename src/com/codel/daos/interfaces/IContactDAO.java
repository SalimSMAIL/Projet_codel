package com.codel.daos.interfaces;

import java.util.List;

import com.codel.entities.Contact;

public interface IContactDAO extends IDAO<Contact>{

	List<Contact> searchContact(String query);

	List<Contact> findRestContact(long idGroup);

}
