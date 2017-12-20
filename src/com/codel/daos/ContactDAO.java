package com.codel.daos;

public class ContactDAO {

	public static void add(String id, String firstName, String lastName, String email){
		System.out.println("je suis dans le DAO contact, tu viens d'ajouter "+ firstName+" "+lastName);
	}
}
