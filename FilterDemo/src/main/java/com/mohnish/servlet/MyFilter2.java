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
public class MyFilter2 implements Filter 
{
	
	private FilterConfig fconfig;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Prefilteration of second filter");
		chain.doFilter(request, response);
		out.print("postfilteration of second filter");

		
	}
	
	
	public void init(FilterConfig fconfig) throws ServletException
	{
		
		this.fconfig = fconfig;
		
	}
	
	
	public void destroy()
	{
		
		System.out.println("Filter destroyed");
		fconfig = null;
	}
	
	

}
