package com.mohnish.main;

import java.util.Scanner;

import com.mohnish.conn.DBConnect;
import com.mohnish.dao.ShoesDao;

public class DeleteDataMain 
{
	
	public static void main(String[] args)
	{
		
		ShoesDao sd = new ShoesDao(DBConnect.getConn());
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id which you wish to delete");
		int id = sc.nextInt();
		boolean f = sd.deleteData(id);
		if(f)
		System.out.println("Data deleted successfully");
		else
		System.out.println("Something went wrong on the server");
				
	}

}
