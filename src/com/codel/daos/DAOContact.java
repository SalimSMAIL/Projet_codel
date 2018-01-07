package com.codel.daos;

public class DAOContact {

	public boolean checkContact(String email, String password){
		if(email.equals(password)) return true;
		else return false;
	}
	
	public void add(String id, String firstName, String lastName, String email){
		System.out.println("je suis dans le DAO contact, tu viens d'ajouter "+ firstName+" "+lastName);
	}
	
	public void search(String id, String firstName, String lastName, String email){
		System.out.println("je suis dans le DAO contact, tu viens de chercher "+ firstName +" "+ "lastName");
	}
	
	public void remove(String id){
		System.out.println("je suis dans le DAO contact, tu viens de supprimer "+ id);
	}
	
	public void update(String id, String firstName, String lastName, String email){
		System.out.println("je suis dans le DAO contact, tu viens de modifier "+ firstName+" "+lastName);
	}
}
