package com.mohnish.ChangePassword;

public class UserAlreadyExistsException extends RuntimeException 
{
	
	private final static long serialVersionUID = 1L;
	
	public UserAlreadyExistsException(String mes)
	{
		
		super(mes);
	}

}
