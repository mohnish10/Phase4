package com.mohnish.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	
	private final static long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		BigDecimal pprice = new BigDecimal(price);
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties props = new Properties();
		props.load(in);
		Connection conn = DBConfig.getConnection(props);
		
		
		try
		{
			
			PreparedStatement pst = conn.prepareStatement("update eproduct set name=?,price=? where id=?");
			pst.setString(1,name);
			pst.setBigDecimal(2,pprice);
			pst.setInt(2, id);
			
			
			int x = pst.executeUpdate();
			
			
			if(x>0)
			response.sendRedirect("list");
			else
			out.print("Error while inserting data");	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
}
	
	
	
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
	
	doGet(request,response);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
