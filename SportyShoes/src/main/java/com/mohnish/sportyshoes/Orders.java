package com.mohnish.sportyshoes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders 
{
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	private Integer userId;
	
	private String date;
	
	private Integer shoeId;
	
	

}
