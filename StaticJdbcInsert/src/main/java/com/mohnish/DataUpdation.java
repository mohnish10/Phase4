package com.mohnish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataUpdation 
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
			PreparedStatement ps = conn.prepareStatement("update shoes set colour='blue' where id=1");
			int x = ps.executeUpdate();
			if(x>0)
			System.out.println("Data has been updated");
			else
			System.out.println("Data has not been updated");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
