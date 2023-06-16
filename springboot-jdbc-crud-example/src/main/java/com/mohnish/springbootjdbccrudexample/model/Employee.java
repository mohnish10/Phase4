package com.mohnish.springbootjdbccrudexample.model;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Employee 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	
	public Employee()
	{
		
	}
	
	
	public Employee(long id,String firstName,String lastName,String email)
	{
		
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = email;		
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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
	
	
	

}
