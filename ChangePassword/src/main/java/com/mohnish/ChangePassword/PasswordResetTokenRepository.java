package com.mohnish.ChangePassword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Long> 
{
	
	PasswordResetToken findByToken(String passwordResetToken);

}
