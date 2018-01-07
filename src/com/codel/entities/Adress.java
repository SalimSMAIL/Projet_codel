package com.codel.entities;

public class Adress {
	private long adress_id;
	private String street;
	private String city;
	private String zip;
	private String country;
	//private Contact contact;
	
	public Adress(long adress_id, String street, String city, String zip, String country) {
		super();
		this.adress_id = adress_id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public long getAdress_id() {
		return adress_id;
	}
	public void setAdress_id(long adress_id) {
		this.adress_id = adress_id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
