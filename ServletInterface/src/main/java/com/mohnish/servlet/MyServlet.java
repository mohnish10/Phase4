package com.mohnish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/my")
public class MyServlet implements Servlet
{
	
	private ServletConfig config;
	

	public void init(ServletConfig config) throws ServletException 
	{
		
		System.out.println("Servlet initialized");
		this.config=config;
		
	}

	public ServletConfig getServletConfig() 
	{
		
		return config;

	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		System.out.println("Request recieved");
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		out.print("Welcome<br>");
		out.print(getServletInfo());
		out.print("<br>Details<br>");
		out.print("Content Length"+req.getContentLength()+"<br>");
		out.print("Content Type:"+req.getContentType());
		
	}

	public String getServletInfo() 
	{

		return config.getServletName()+" ";
	}

	public void destroy() 
	{
		
		System.out.println("Servlet destroyed");
		
	}
	
	
	
	
	
	
	

}
