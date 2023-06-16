package com.mohnish.finalnail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mohnish.model.Attendees;

public class EventManager 
{
	
	public static void main(String[] args)
	{
		
		System.out.println("Welcome to Event Management system");
		System.out.println("Developed by Mohnish Pawar");
		System.out.println("Contact details are as follows:-");
		System.out.println("Email is mohnishpwr10@gmail.com");
		System.out.println("Mobile number is :- 9999999999");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the following details for attending events");
		System.out.println();
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		System.out.println();
		System.out.println("Please enter your email");
		String email = sc.nextLine();
		System.out.println();
		System.out.println("Please enter your phone number");
		String phoneNumber = sc.nextLine();
		Attendees a = new Attendees(sc.nextLine(),sc.nextLine(),sc.nextLine());
		Attendees a1 = new Attendees(sc.nextLine(),sc.nextLine(),sc.nextLine());
		Attendees a2 = new Attendees(sc.nextLine(),sc.nextLine(),sc.nextLine());
		System.out.println();		
        List<Attendees> list = new ArrayList<>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		System.out.println(list);
		
		
	}

}
