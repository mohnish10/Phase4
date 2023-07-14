package com.mohnish;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/fetch")
public class FetchServlet extends HttpServlet
{
	
	private final static long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		try
		{
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			
			Session session = factory.openSession();
			
			List<EProduct1> list = session.createQuery("from EProduct1").list();
			
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html");
			
			out.println("<html><body>");
			
			out.println("<b>Product Listing</b><br>");
			
			for(EProduct1 e:list)
			{
				
				out.println("ID: "+String.valueOf(e.getId())+", Name:"+e.getName()+", Price:"+String.valueOf(e.getPrice())+", Date Added: "+e.getDateAdded().toString());
				
				List<Color> colors = e.getColors();
				
				out.println("Colors: ");
				
				for(Color c: colors)
				out.print(c.getName()+"&nbsp;");
				
				
				Collection<ScreenSizes> sizes = e.getScreenSizes();
				
				out.println(", Screen Sizes: ");
				
				for(ScreenSizes s:sizes)
				out.print(s.getSize()+"&nbsp;");
				
				
				Set<OS> os = e.getOs();
				out.println(", OS: ");
				for(OS o:os)
				out.println(o.getName()+"&nbsp;");
				
				
				Map finances = e.getFinance();
				out.println(", Finance options: ");
				
				if(finances.get("CREDITCARD")!=null)
				{
					
					Finance f = (Finance) finances.get("CREDITCARD");
					out.println(f.getName()+"&nbsp;");
				}
				
				
				if(finances.get("BANK")!=null)
				{
					
					Finance f = (Finance) finances.get("BANK");
					out.println(f.getName()+"&nbsp;");
				}
				
				
				out.println("<hr>");
				
			}
			
			session.close();
			
			
			out.println("</body></html>");
			
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
