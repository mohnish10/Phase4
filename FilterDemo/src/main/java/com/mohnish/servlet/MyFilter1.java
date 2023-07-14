package com.mohnish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/welcome")
public class MyFilter1 implements Filter
{

	
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
		System.out.println("Filter initialized");
		
	}
	
	
	
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Pre-filtration of first filter <br>");
		chain.doFilter(request, response);
		out.println("Post filtration of first filter<br>");
		
	}
	
	
	public void destroy()
	{
		
		System.out.println("Filter destroyed");
	}
	
	

}
