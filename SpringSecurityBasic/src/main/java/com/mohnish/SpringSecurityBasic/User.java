package com.mohnish.SpringSecurityBasic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User 
{
	
	private String name;
	private String password;
	private String role;

}
