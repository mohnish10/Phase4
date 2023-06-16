package com.mohnish.springboot.exceptionhandling;

public class Student 
{
	
	private int id;
	private String name;
	
	public Student()
	{
		
	}
	
	
	public Student(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	
	public String getName()
	{
		
		return name;
	}
	
	
	public void setId(int id)
	{
		
		this.id = id;
	}
	
	
	public void setName(String name)
	{
		
		this.name = name;
	}

}
