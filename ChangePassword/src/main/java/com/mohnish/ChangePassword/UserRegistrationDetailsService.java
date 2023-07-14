package com.mohnish.ChangePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationDetailsService implements UserDetailsService 
{
	
	@Autowired
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		
		return userRepository.findByEmail(email).map(UserRegistrationDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));		

	}
	
	
	
	
	
	
	
	

}
