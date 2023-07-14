package com.mohnish.main;

import java.util.List;

import com.mohnish.conn.DBConnect;
import com.mohnish.dao.ShoesDao;
import com.mohnish.entity.Shoes;

public class RetrieveDataMain 
{
	
	public static void main(String[] args)
	{
		
		ShoesDao sd = new ShoesDao(DBConnect.getConn());
		
		List<Shoes> list = sd.getAllData();
		
		for(Shoes s : list)
		{
			
			System.out.println("Id:-"+s.getId());
			System.out.println("Color:-"+s.getColor());
			System.out.println("Name:-"+s.getName());
			System.out.println("price:-"+s.getPrice());
			System.out.println("Quantity:-"+s.getQuantity());
			System.out.println("Size:-"+s.getSize());
			System.out.println("----------------------------");
		}
		
		
		
		
	}

}
