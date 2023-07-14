package com.mohnish.ChangePassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest 
{
	
	String firstName;
	String lastName;
	String email;
	String password;
	String role;

}
