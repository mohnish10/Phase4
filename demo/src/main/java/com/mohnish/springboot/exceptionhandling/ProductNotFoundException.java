package com.mohnish.springboot.exceptionhandling;



public class ProductNotFoundException extends RuntimeException
{
	
	public ProductNotFoundException()
	{
		
		
	}
	
	
	public ProductNotFoundException(String mes)
	{
		
		super(mes);

	}
	
	
	public String toString()
	{
		
		return "ProductNotFoundException" + super.toString();
	}
	

}
