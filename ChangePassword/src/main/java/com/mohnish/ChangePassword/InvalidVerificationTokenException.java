package com.mohnish.ChangePassword;

public class InvalidVerificationTokenException extends RuntimeException
{
	
	private final static long serialVersionUID = 1L;
	
	public InvalidVerificationTokenException(String message)
	{
		
		super(message);
	}

}
