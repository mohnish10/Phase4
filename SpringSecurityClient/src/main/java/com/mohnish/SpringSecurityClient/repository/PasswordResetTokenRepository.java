package com.mohnish.SpringSecurityClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.SpringSecurityClient.entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> 
{
	
	PasswordResetToken findByToken(String token);

}
