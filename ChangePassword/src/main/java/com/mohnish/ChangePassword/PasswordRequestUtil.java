package com.mohnish.ChangePassword;

import lombok.Data;

@Data
public class PasswordRequestUtil 
{
	
	public String email;
	public String oldPassword;
	public String newPassword;

}
