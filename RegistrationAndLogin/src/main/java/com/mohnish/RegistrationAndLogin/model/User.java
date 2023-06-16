package com.mohnish.RegistrationAndLogin.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String name;
	

	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = {@JoinColumn(
		            name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
	
	
	private List<Role> roles = new ArrayList<>();
	
	
	

		


	
	
		
	

}
