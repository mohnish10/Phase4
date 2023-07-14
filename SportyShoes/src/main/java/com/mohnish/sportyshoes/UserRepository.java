package com.mohnish.sportyshoes;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	
	Optional<User> findByUserName(String username);
	
	
	Optional<User> findByEmail(String email);

	

}
