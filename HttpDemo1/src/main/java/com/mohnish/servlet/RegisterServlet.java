package com.mohnish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		out.print("<h1>Successfully Registered</h1>");
		out.print("<h3>Following are the details you have submitted</h3>");
		out.print("<p>First name:"+fname+"<br>");
		out.print("<p>Last name:"+lname+"<br>");
		out.print("<p>Registered email:"+email+"<br>");
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		doGet(request,response);
	}
	

}
