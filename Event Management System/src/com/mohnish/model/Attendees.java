package com.mohnish.model;

public class Attendees 
{
	
	private String name;
	private String email;
	private String phoneNumber;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public Attendees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Attendees(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public String toString() {
		return "Attendees [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
	
	
	
	

}
