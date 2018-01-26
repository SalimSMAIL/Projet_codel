package com.codel.services.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;

public class CheckServices {
	
	public JSONObject checkAddContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws Throwable {
		
		JSONObject error = new JSONObject();

		if(firstName == null || !firstName.matches("^[a-zA-Z]{2,}$")){
			error.accumulate("errors", "firestName");
		}
		if(lastName == null || !lastName.matches("^[a-zA-Z]{2,}$")){
			error.accumulate("errors", "lastName");
		}
		if(email == null || !email.matches("^[A-Za-z][A-Za-z0-9._-]+@[A-Za-z0-9-_]+\\.?[A-Za-z0-9-_]+\\.[A-Za-z]{2,6}$")){
			error.accumulate("errors", "email");
		}
		if(streetNumber == null || !streetNumber.matches("^[0-9]+$")){
			error.accumulate("errors", "streetNumber");
		}
		if(streetType == null || !streetType.matches("^[A-Za-z]{2,}$")){
			error.accumulate("errors", "streetType");
		}
		if(streetName == null || !streetName.matches("^[A-Za-z]{2,}$")){
			error.accumulate("errors", "streetName");
		}
		if(codePostal == null || !codePostal.matches("^[1-9][0-9]{4}$")){
			error.accumulate("errors", "codePostal");
		}
		if(city == null || !city.matches("^[A-Za-z]{2,}$")){
			error.accumulate("errors", "city");
		}
		if(country == null || !country.matches("^[A-Za-z]{2,}$")){
			error.accumulate("errors", "country");
		}

		if(error.length()!=0){
			return error;
		}else{
			return (JSONObject) pjp.proceed();
		}
			
	}
	
}
