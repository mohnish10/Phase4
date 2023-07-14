package com.mohnish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		String uname = request.getParameter("uname");	
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		if(pass.equals("admin123"))
		{
			
			Cookie cookie = new Cookie("logindetails",uname);
			response.addCookie(cookie);
			response.sendRedirect("dashboard");
		}
		else
		{
		out.print("Wrong username or password");	
		}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		doGet(request,response);
	}

}
