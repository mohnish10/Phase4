package com.mohnish.springsecurity.jwt;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Configuration
@Component
public class JwtSecretKey 
{
	
	private final JwtConfig jwtConfig;
	
	
	@Autowired
	public JwtSecretKey(JwtConfig jwtConfig)
	{
		
		this.jwtConfig = jwtConfig;
	}
	
	
	@Bean
	public SecretKey getSecretKey()
	{
		
		return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
	}
	
	

}
