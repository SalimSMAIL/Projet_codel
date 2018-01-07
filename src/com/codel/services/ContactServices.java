package com.codel.services;

import com.codel.daos.DAOContact;

public class ContactServices {
	
	private final static DAOContact daoContact = new DAOContact();

	public static boolean login(String email, String password){
		return daoContact.checkContact(email, password);
	}
	
	public static void add(String id, String firstName, String lastName, String email){
		daoContact.add(id, firstName, lastName, email);
	}
	
	public static void search(String id, String firstName, String lastName, String email){
		daoContact.search(id, firstName, lastName, email);
	}
	
	public static void remove(String id){
		daoContact.remove(id);
	}
	
	public static void update(String id, String firstName, String lastName, String email){
		daoContact.update(id, firstName, lastName, email);
	}
}
