package com.mohnish.sportyshoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class User 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer userId;
	private String userName;
	private String password;
	private String role;
	private String email;
	
	


	
	

	
	

	
	

}
