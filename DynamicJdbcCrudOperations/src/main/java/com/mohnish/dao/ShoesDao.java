package com.mohnish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mohnish.entity.Shoes;

public class ShoesDao 
{
	
	private Connection conn;
	
	
	public ShoesDao(Connection conn)
	{
		
		super();
		this.conn = conn;
	}
	
	
	public boolean dataInsert(Shoes shoes)
	{
		
		boolean f = false;
		
		try
		{
			
			PreparedStatement ps = conn.prepareStatement("insert into shoes(id,color,name,price,quantity,size) values(?,?,?,?,?,?)");
			ps.setInt(1, shoes.getId());
			ps.setString(2,shoes.getColor());
			ps.setString(3,shoes.getName());
			ps.setDouble(4,shoes.getPrice());
			ps.setInt(5,shoes.getQuantity());
			ps.setInt(6,shoes.getSize());
			
			
			int a = ps.executeUpdate();
			
			if(a==1)
			f=true;	
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	public boolean editData(Shoes shoes)
	{
		
		boolean f = false;
		
		try
		{
			
			PreparedStatement ps = conn.prepareStatement("update shoes set name=?,price=? where id=?");
			ps.setString(1, shoes.getName());
			ps.setDouble(2, shoes.getPrice());
			ps.setInt(3, shoes.getId());
			
			int i = ps.executeUpdate();
			if(i==1)
			f=true;
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public boolean deleteData(int id)
	{
		
		boolean f = false;
		
		try
		{
			
			PreparedStatement ps = conn.prepareStatement("delete from shoes where id=?");
			ps.setInt(1, id);
			
			int x = ps.executeUpdate();
			
			if(x==1)
			f=true;	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	
	public Shoes getShoes(int id)
	{
		
		Shoes obj = null;
		
		boolean f = false;
		
		try
		{
			
			PreparedStatement ps = conn.prepareStatement("select * from shoes where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				obj = new Shoes();
				obj.setId(rs.getInt(1));
				obj.setColor(rs.getString(2));
				obj.setName(rs.getString(3));
				obj.setPrice(rs.getDouble(4));
				obj.setQuantity(rs.getInt(5));
				obj.setSize(rs.getInt(6));
			}
			
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
          return obj;	
	}
	
	
	public List<Shoes> getAllData()
	{
		
	List<Shoes> list = new ArrayList<Shoes>();
	
	Shoes obj = null;
	
	try
	{
		
		PreparedStatement ps = conn.prepareStatement("select * from shoes");
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next())
		{
			
			obj = new Shoes();
			obj.setId(rs.getInt(1));
			obj.setColor(rs.getString(2));
			obj.setName(rs.getString(3));
			obj.setPrice(rs.getDouble(4));
			obj.setQuantity(rs.getInt(5));
			obj.setSize(rs.getInt(6));
			list.add(obj);
		}
		
	   
		
	}
	catch(Exception ex)
	{
		
		ex.printStackTrace();
	}
	
	
	
	return list;	
		
	}
	
	
	
	
	
	
	

}
