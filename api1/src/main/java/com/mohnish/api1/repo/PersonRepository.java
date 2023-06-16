package com.mohnish.api1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.api1.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer>
{
	
	

}
