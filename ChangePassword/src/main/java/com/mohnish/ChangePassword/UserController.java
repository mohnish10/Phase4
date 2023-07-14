package com.mohnish.ChangePassword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController 
{
	
	@Autowired
	private final UserService userService;
	
	
	@GetMapping
	public List<User> getUsers()
	{
		
		return userService.getUsers();
	}
	

}
