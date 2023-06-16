package com.mohnish.sportyshoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class UserService
{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private final User user;
	
	
	public UserService(User user)
	{
		
		this.user = user;
	}
	
	
	
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll() 
	{
		
		return repo.findAll();

	}

	
	public User getUserById(int id)
	{
		
		if(repo.findById(id)!=null)
		{
			return repo.findById(id).get();
		}
		else
		return null;	
	}
	
	

	
	


	
	
    public User registerUser(User user) 
	{
		
		user = new User();
        user.setUserName(user.getUserName());
        user.setRole("USER");
        user.setPassword((user.getPassword()));

        repo.save(user);
        return user;

	}


	

	
                
    


	
    
    

    
    


	

	

}
