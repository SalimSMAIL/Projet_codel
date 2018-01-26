package com.codel.services.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.codel.enumeration.Response;

public class CheckServices {

	public Object checkAddContact(ProceedingJoinPoint pjp, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) {
		
		System.out.println("Je suis entrée dans l'aspect");
		
		List<Response> responses = new ArrayList<>();
		
		if(firstName==null || firstName.equals("")) responses.add(Response.FIRSTNAME_NOT_FOUND);
		if(lastName==null || lastName.equals("")) responses.add(Response.LASTTNAME_NOT_FOUND);
		if(email==null || email.equals("")) responses.add(Response.EMAIL_NOT_FOND);
		if(streetNumber==null || streetNumber.equals("")) responses.add(Response.STREETNUMBER_NOT_FOUND);
		if(streetType==null || streetType.equals("")) responses.add(Response.STREETTYPE_NOT_FOUND);
		if(streetName==null || streetName.equals("")) responses.add(Response.STREETNAME_NOT_FOUND);
		if(codePostal==null || codePostal.equals("")) responses.add(Response.CODEPOSTAL_NOT_FOUND);
		if(city==null || city.equals("")) responses.add(Response.CITY_NOT_FOUND);
		if(country==null || country.equals("")) responses.add(Response.COUNTRY_NOT_FOUND);
		
		if(responses.isEmpty()){
			try {
				System.out.println("check réussi");
				return pjp.proceed();
			} catch (Throwable e) {
				return null;
			}
		}else{
			return responses;
		}
		
	}
	
	public void checkTest(ProceedingJoinPoint pjp, String test){
		System.out.println("je suis dans l'astect");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
