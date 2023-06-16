package com.mohnish.RestfulWebServices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.RestfulWebServices.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> 
{

	
}
