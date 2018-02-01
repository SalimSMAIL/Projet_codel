package com.codel.services;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.codel.daos.interfaces.IEntrepriseDAO;
import com.codel.entities.Address;
import com.codel.entities.Entreprise;
import com.codel.entities.PhoneNumber;

public class EntrepriseServices {

	private IEntrepriseDAO entrepriseDAO;

	public EntrepriseServices(){
		super();
	}

	public EntrepriseServices(IEntrepriseDAO entrepriseDAO){
		this.entrepriseDAO = entrepriseDAO;
	}

	public JSONObject addEntreprise(String numSiret, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, 
			String city, String country, Map<String, String> listPhones) throws JSONException{

		long sn;
		long nSiret;
		try{
			sn = Long.parseLong(streetNumber);
			nSiret = Long.parseLong(numSiret);
		}catch(Exception e){
			sn=1000;
			nSiret = 0;
		}
		Entreprise entreprise = new Entreprise(firstName, lastName, email, new Address(sn, 
				streetType, streetName, codePostal, city, country), nSiret);
		if(listPhones.containsKey("mobilePhone") && listPhones.get("mobilePhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("mobilePhone"), "mobile", entreprise);
		if(listPhones.containsKey("homePhone") && listPhones.get("homePhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("homePhone"), "home", entreprise);
		if(listPhones.containsKey("professionnalPhone") && listPhones.get("professionnalPhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("professionnalPhone"), "professionnal", entreprise);
		long id = entrepriseDAO.save(entreprise);

		return new JSONObject().put("id", id);

	}

}
