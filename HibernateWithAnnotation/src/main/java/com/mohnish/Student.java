package com.mohnish;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdata")
public class Student 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int id;
	private String name;
	private String email;
	private String password;
	
	
	public Student()
	{		
		super();
	}
	
	
	public Student(String name,String email,String password)
	{
		
		super();
		this.name=name;
		this.email=email;
		this.password=password;
	}
	
	
	public int getId()
	{
		
		return id;
	}
	
	
	public void setId(int id)
	{
		
		this.id=id;
	}
	
	
	public String getName()
	{
		
		return name;
	}
	
	
	public void setName(String name)
	{
		
		this.name=name;
	}
	
	
	public String getEmail(String email)
	{
		
		return email;
	}
	
	
	public void setPassword(String password)
	{
		
		this.password=password;
	}
	
	
	public void setEmail(String email)
	{
		
		this.email = email;
	}
	
	
	public String getPassword()
	{
		
		return password;
	}
	
	

}
