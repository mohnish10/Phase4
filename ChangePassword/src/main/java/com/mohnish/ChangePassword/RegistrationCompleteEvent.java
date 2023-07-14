package com.mohnish.ChangePassword;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent
{
	
	private final static long serialVersionUID = 1L;
	
	private User user;
	private String applicationUrl;
	
	
	public RegistrationCompleteEvent(User user,String applicationUrl)
	{
		
		super(user);
		this.user = user;
		this.applicationUrl = applicationUrl;
	}
	
	

}
