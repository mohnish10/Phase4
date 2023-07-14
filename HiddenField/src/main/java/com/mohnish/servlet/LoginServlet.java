package com.mohnish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		if(pass.equals("admin123"))
		{
			
			out.print("Successfully logged in!!! <br>");
			out.print("<form action='dashboard' method='post'>");
			out.print("<input type='hidden' name='user' value='"+uname+"'>");
			out.print("<input type='submit' value='dashboard'>");
		}
		else
		out.print("Wrong username or password");
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		doGet(request,response);
	}
	
	
	

}
