package com.codel.services;

import com.codel.daos.interfaces.IPhoneNumberDAO;

public class PhoneNumberServices {
	private IPhoneNumberDAO phoneNumberDAO;

	public PhoneNumberServices(){
	}


	public PhoneNumberServices(IPhoneNumberDAO phoneNumberDAO){
		this.phoneNumberDAO = phoneNumberDAO;
	}
	
	public void delete(long id){
		phoneNumberDAO.delete(id);
	}
}
