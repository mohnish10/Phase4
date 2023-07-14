package com.mohnish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect 
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
			
			
			if(conn!=null)
			{
				
				System.out.println("Connection established");
				Statement st = conn.createStatement();
				int x = st.executeUpdate("insert into shoes(id,colour,name,price,quantity,size) values(6,'blue','bata kolhapur chappals',8000.50,10,5)");
				if(x>0)
				System.out.println("Data has been inserted successfully into database");
				else
				System.out.println("Error while inserting data");	
			}
			else
			System.out.println("Error while inserting data");
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
