package com.mohnish.SpringSecurityClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.SpringSecurityClient.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> 
{
	
	User findByEmail(String email);
	

}
