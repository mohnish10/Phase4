package com.mohnish;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main 
{
	
	public static void main(String[] args)
	{
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		Student s1 = new Student("mohnish","mohnishpwr10@gmail.com","12345");
		
		
		session.save(s1);
		
		
		tx.commit();
		
		
		System.out.println("Data inserted successfully");
		
			
		
		
		
		
		
	}

}
