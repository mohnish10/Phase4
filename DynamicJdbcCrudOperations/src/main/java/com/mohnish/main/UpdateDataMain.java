package com.mohnish.main;



import java.util.Scanner;

import com.mohnish.conn.DBConnect;
import com.mohnish.dao.ShoesDao;
import com.mohnish.entity.Shoes;

public class UpdateDataMain 
{
	
	public static void main(String[] args)
	{
		
		Shoes shoes = new Shoes();
		Scanner sc = new Scanner(System.in);

		shoes.setId(1);
		shoes.setName("CROCS MENS BLACK CROCBAND SHOES");
		shoes.setPrice(7500);
		
		
		ShoesDao sd = new ShoesDao(DBConnect.getConn());
		boolean f = sd.editData(shoes);
		
		
		if(f)
		System.out.println("Data updated successfully");
		else
		System.out.println("Something wrong on server");	
		
		
		
		
	}

}
