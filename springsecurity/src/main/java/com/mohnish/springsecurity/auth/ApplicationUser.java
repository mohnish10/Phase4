package com.mohnish.springsecurity.auth;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails 
{
	
	private final String username;
	private final String password;
	private final Set<? extends GrantedAuthority> grantedAuthorities;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isCredentialsNonExpired;
	private final boolean isEnabled;
	
	
	public ApplicationUser(String username,
			String password,
			Set<? extends GrantedAuthority> grantedAuthorities,
			boolean isAccountNonExpired,
			boolean isAccountNonLocked,
			boolean isCredentialsNonExpired,
			boolean isEnabled)
	{
		
		this.username = username;
		this.password = password;
		this.grantedAuthorities = grantedAuthorities;	
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
		
		
	}
	
	
	public ApplicationUser(String username,String password,Set<? extends GrantedAuthority> grantedAuthorities)
	{
		
		this(username,password,grantedAuthorities,true,true,true,true);	
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}
