package com.mohnish.springsecurity.security;




public enum ApplicationUserAuthority 
{
	
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	
	
	ApplicationUserAuthority(String permission)
	{
		
		this.permission = permission;
	}
	
	
	public String getPermission()
	{
		
		return permission;
	}
	
	

}
