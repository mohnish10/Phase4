package com.mohnish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataRetrieval 
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
				String query = "select * from shoes";
				PreparedStatement pst = conn.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					
					System.out.println(rs.getInt("id")+" "+rs.getString("colour")+" "+rs.getString("name")+" "+rs.getFloat("price")+" "+rs.getInt("quantity")+" "+rs.getInt("size"));
				}
			}
			else
			System.out.println("Error while connecting with database");	
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
