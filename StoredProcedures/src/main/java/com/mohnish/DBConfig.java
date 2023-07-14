package com.mohnish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig 
{
	
	public static Connection getConnection(Properties props)
	{
		
		Connection conn = null;
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		return conn;
		
	}

}
