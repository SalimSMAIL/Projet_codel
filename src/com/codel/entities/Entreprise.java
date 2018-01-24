package com.codel.entities;

public class Entreprise extends Contact{

	private long numSiret;
	
	

	public Entreprise() {
		super();
	}

	public Entreprise(String firstName, String lastName, String email, Address address, long numSiret) {
		super(firstName, lastName, email, address);
		this.numSiret = numSiret;
	}

	public long getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(long numSiret) {
		this.numSiret = numSiret;
	}
	
	
}
