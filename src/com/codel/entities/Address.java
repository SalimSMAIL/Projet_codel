package com.codel.entities;

public class Address {
	
	private long addressId;
	private long streetNumber;
	private String streetType;
	private String streetName;
	private String codePostal;
	private String city;
	private String country;
	
	public Address() {
		super();
	}
	public Address(long streetNumber, String streetType, String streetName, String codePostal, String city,
			String country) {
		this.streetNumber = streetNumber;
		this.streetType = streetType;
		this.streetName = streetName;
		this.codePostal = codePostal;
		this.city = city;
		this.country = country;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public long getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(long streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
