package com.mohnish.RestfulWebServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohnish.RestfulWebServices.entity.User;
import com.mohnish.RestfulWebServices.repo.UserRepo;

@Service
public class UserService 
{
	@Autowired
	private UserRepo userRepo;
	
	
	public User addUser(User user)
	{
		
		return userRepo.save(user);
	}
	
	
	public List<User> getAllUsers()
	{
		
		return userRepo.findAll();
	}
	
	
	public User getUserById(int id)
	{
				
		if(userRepo.findById(id).isPresent())
		return userRepo.findById(id).get();	
		else
		return null;
	}
	
	
	public User updateUser(User user,int id)
	{
		
		if(userRepo.findById(id).isPresent())
		{
			
			User old = userRepo.findById(id).get();
			old.setCountry(user.getCountry());
			old.setName(user.getName());
			old.setEmail(user.getEmail());
			old.setPassword(user.getPassword());
			
			return userRepo.save(old);
			
		}
		else
		
			return null;
			
	}
	
	
	public boolean deleteUser(int id)
	{
		
		if(userRepo.findById(id).isPresent())
		{
			
			userRepo.deleteById(id);
			return true;
		}
		
		
		return false;
	}
	

}
