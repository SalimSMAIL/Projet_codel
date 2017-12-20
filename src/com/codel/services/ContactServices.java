package com.codel.services;

import com.codel.daos.ContactDAO;

public class ContactServices {

	public static boolean login(String email, String password){
		if(email.equals(password)) return true;
		else return false;
	}
	
	public static void add(String id, String firstName, String lastName, String email){
		ContactDAO.add(id, firstName, lastName, email);
	}
}
