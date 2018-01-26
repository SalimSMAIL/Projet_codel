package com.codel.services.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;

public class CheckServices {
	
	public JSONObject checkAddContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws Throwable {
		
		System.out.println("Je suis dans l'aspect add");
		pjp.proceed();

		return null;
			
	}
	
	public String test(ProceedingJoinPoint pjp, String c){
		System.out.println("Je suis dans l'aspect");
		return "aspect";
	}
	
}
