package com.space.bookshelf.model;

public class Person 
{
	private String id = "";
	
	private String firstName = "";
	private String lastName = "";
	
	private String emailId = "";
	private String phoneNumber = "";
	
	private String address = "";
	private String locality = "";
	private String city = "";	
	private String state = "";
	private String country = "";
	private String latitude = "";
	private String longitude = "";
	
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	public String toString()
	{
		return id + "| " + firstName + "| " + lastName + "| " + emailId + "| " + phoneNumber 
				+ "| " + address + "| " + locality + "| " + city + "| " + state
				+ "| " + country + "| " + latitude + "| " + longitude + "<br/>";
		
		
	}



	
	public static void main(String args[])
	{
		System.out.println("Hello world");
	}


}
