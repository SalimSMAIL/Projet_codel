package com.codel.services.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONArray;
import org.json.JSONObject;

import com.codel.entities.Contact;

public class CheckServices {
	
	public JSONObject checkAddContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country, Map<String, String> listPhones) throws Throwable {
		
		return checkInfoContact(pjp, firstName, lastName, email, streetNumber, streetType, streetName, codePostal, city, country);
			
	}
	
	public JSONObject checkUpdateContact(ProceedingJoinPoint pjp, Contact contact, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country, Map<String, String> listPhones) throws Throwable {
		
		return checkInfoContact(pjp, firstName, lastName, email, streetNumber, streetType, streetName, codePostal, city, country);
			
	}
	
	public JSONObject checkAddEntreprise(ProceedingJoinPoint pjp, String numSiret, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country, Map<String, String> listPhones) throws Throwable {
		JSONObject error = new JSONObject();
		if(numSiret == null || !numSiret.matches("^[0-9]{2,}$")){
			error.accumulate("errors", "numSiret");
		}
		if(error.length()!=0){
			return error;
		}
		return checkInfoContact(pjp, firstName, lastName, email, streetNumber, streetType, streetName, codePostal, city, country);
			
	}
	
	private JSONObject checkInfoContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws Throwable{
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
		if(streetNumber == null || !streetNumber.matches("^[0-9]{1,3}$")){
			error.accumulate("errors", "streetNumber");
		}
		if(streetType == null || !streetType.matches("^[A-Za-z]{2,}$")){
			error.accumulate("errors", "streetType");
		}
		if(streetName == null || !streetName.matches("^[A-Za-z ]{2,}$")){
			error.accumulate("errors", "streetName");
		}
		if(codePostal == null || !codePostal.matches("^[1-9][0-9]{4}$")){
			error.accumulate("errors", "codePostal");
		}
		if(city == null || !city.matches("^[A-Za-z ]{2,}$")){
			error.accumulate("errors", "city");
		}
		if(country == null || !country.matches("^[A-Za-z ]{2,}$")){
			error.accumulate("errors", "country");
		}

		if(error.length()!=0){
			return error;
		}else{
			return (JSONObject) pjp.proceed();
		}
	}
	
}
