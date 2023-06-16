package com.mohnish.sportyshoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shoes 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shoeId;
	private String name;
	private float price;
	private int size;
	private String color;

}
