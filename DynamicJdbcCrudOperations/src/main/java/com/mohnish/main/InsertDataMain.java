package com.mohnish.main;

import java.util.Scanner;

import com.mohnish.conn.DBConnect;
import com.mohnish.dao.ShoesDao;
import com.mohnish.entity.Shoes;

public class InsertDataMain 
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter shoe Id");
		int id = sc.nextInt();
		System.out.println("Enter shoe Color");
		String color = sc.next();
		System.out.println("Enter shoe name");
		String name = sc.next();
		System.out.println("Enter shoe price");
		Double price = sc.nextDouble();
		System.out.println("Enter shoe quantity");
		int quantity = sc.nextInt();
		System.out.println("Enter shoe size");
		int size = sc.nextInt();
		
		
		Shoes shoes = new Shoes();
		shoes.setId(id);
		shoes.setColor(color);
		shoes.setName(name);
		shoes.setPrice(price);
		shoes.setQuantity(quantity);
		shoes.setSize(size);
		
		
		ShoesDao sd = new ShoesDao(DBConnect.getConn());
		boolean f = sd.dataInsert(shoes);
		
		
		if(f)
		System.out.println("Data inserted successfully");
		else
		System.out.println("Something went wrong on the server");	
		
		
		
	}

}
