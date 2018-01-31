package com.codel.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.daos.EntrepriseDAO;
import com.codel.entities.Address;
import com.codel.entities.Entreprise;

public class EntrepriseServices {

	public Entreprise findById(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDao");
		return entrepriseDAO.findById(id);
	}
	
	public List<Entreprise> findAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDao");
		return entrepriseDAO.findAll();
	}
	
	public void deleteEntreprisebyId(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDao");
		entrepriseDAO.delete(id);
	}
	
	public JSONObject addEntreprise(String firstName, String lastName, String email, 
				String streetNumber, String streetType, String streetName, String codePostal, String city, String country,String numSiret) throws JSONException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDAO");
		long sn;
		try{
			sn = Long.parseLong(streetNumber);
		}catch(Exception e){
			sn=1000;
		}
		Entreprise entreprise = new Entreprise(firstName, lastName, email, new Address(sn, 
									streetType, streetName, codePostal, city, country),Long.parseLong(numSiret));
		long id = entrepriseDAO.save(entreprise);
		
		return new JSONObject().put("id", id);
		
	}
	
public JSONObject updateEntreprise(Entreprise entreprise, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country,long numSiret) throws JSONException{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDao");
	
	entreprise.setFirstName(firstName);
	entreprise.setLastName(lastName);
	entreprise.setEmail(email);
	entreprise.getAddress().setStreetNumber(Long.parseLong(streetNumber));
	entreprise.getAddress().setStreetName(streetName);
	entreprise.getAddress().setCodePostal(codePostal);
	entreprise.getAddress().setCity(city);
	entreprise.getAddress().setCountry(country);
	
	entrepriseDAO.update(entreprise);
	
	return new JSONObject().put("id", entreprise.getContactId());
	
}

	public List<Entreprise> searchEntreprise(String query){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EntrepriseDAO entrepriseDAO = (EntrepriseDAO)context.getBean("myEntrepriseDao");
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
		List<Entreprise> entreprises_results = new ArrayList<Entreprise>();
		entreprises = entrepriseDAO.findAll();
		for (int i = 0; i < entreprises.size(); i++) {
			if (entreprises.get(i).getFirstName().contains(query)
					|| entreprises.get(i).getLastName().contains(query)
					) {
				entreprises_results.add(entreprises.get(i));
			}		
		}
		if(entreprises.isEmpty()) {
			return null;
		}else {
			return entreprises_results;
		}
			
	}

}
