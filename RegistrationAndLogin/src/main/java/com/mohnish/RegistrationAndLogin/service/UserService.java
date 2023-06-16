package com.mohnish.RegistrationAndLogin.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mohnish.RegistrationAndLogin.dto.UserDto;
import com.mohnish.RegistrationAndLogin.model.User;

public interface UserService
{
	
	void saveUser(UserDto userDto);

	User findByEmail(String email);
	
	List<UserDto> findAllUsers();
	
	
	
	
	

}
