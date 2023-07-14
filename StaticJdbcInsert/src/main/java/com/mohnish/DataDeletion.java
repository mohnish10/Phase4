package com.mohnish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataDeletion 
{
	
	public static void main(String[] args)
	{
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/shoes";
		String username = "root";
		String password = "@theultimateone1";
		
		try
		{
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = conn.prepareStatement("delete from shoes where id=6");
			int x = ps.executeUpdate();
			if(x>0)
			System.out.println("Data has been deleted");
			else
			System.out.println("Data has not been deleted");	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
	}

}
