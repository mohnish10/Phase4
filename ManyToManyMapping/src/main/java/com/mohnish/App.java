package com.mohnish;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
	
	public static void main(String[] args)
	{
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		
		Answer a1 = new Answer();
		
		a1.setAnswerName("Java is a programming language");
		a1.setPostedBy("Sonam Soni");
		
		
		Answer a2 = new Answer();
		
		a2.setAnswerName("Java is a platform");
		a2.setPostedBy("Mohnish");
		
		
		Question q1 = new Question();
		
		q1.setQname("What is Java");
		
		ArrayList<Answer> l1 = new ArrayList<Answer>();
		
		
		l1.add(a1);
		l1.add(a2);
		
		
		q1.setAnswers(l1);
		
		
		Answer a3 = new Answer();
		
		a3.setAnswerName("Servlet is an interface");
		a3.setPostedBy("Vijay Kumar");
		
		
		Answer a4 = new Answer();
		
		a4.setAnswerName("Servlet is an API");
		a4.setPostedBy("Piyush");
		
		
		Question q2 = new Question();
		q2.setQname("What is Servlet");
		
		
		ArrayList<Answer> l2 = new ArrayList<Answer>();
		
		l2.add(a3);
		l2.add(a4);
		
		
		q2.setAnswers(l2);
		
		
		session.persist(q1);
		session.persist(q2);
		
		
		t.commit();
		session.close();
		System.out.println("success");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
