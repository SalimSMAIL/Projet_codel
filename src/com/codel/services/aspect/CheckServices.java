package com.codel.services.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class CheckServices {
	
	public String checkAddContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) {
		
		System.out.println("Je suis dans l'aspect");

			return null;
			
	}
	
	public String test(ProceedingJoinPoint pjp, String c){
		System.out.println("Je suis dans l'aspect");
		return "aspect";
	}
	
}
