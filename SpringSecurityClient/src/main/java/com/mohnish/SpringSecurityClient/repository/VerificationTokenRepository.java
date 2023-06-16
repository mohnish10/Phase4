package com.mohnish.SpringSecurityClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.SpringSecurityClient.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long>
{
	
	
	VerificationToken findByToken(String token);
	
	

}
