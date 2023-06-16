package com.mohnish.springsecurity.security;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import static com.mohnish.springsecurity.security.ApplicationUserAuthority.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;






public enum ApplicationUserRole 
{
	
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ)),  ;
	
	
	private final Set<ApplicationUserAuthority> permissions;
	
	
	public Set<GrantedAuthority> getGrantedAuthorities()
	{
		
		Set<GrantedAuthority> permissions = this.permissions.stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return permissions;
	}


	ApplicationUserRole(Set<ApplicationUserAuthority> permissions)
	{
		
		this.permissions = permissions;
	}
	

}
