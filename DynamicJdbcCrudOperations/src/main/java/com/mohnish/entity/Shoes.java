package com.mohnish.entity;

public class Shoes 
{
	
	private int id;
	private String color;
	private String name;
	private double price;
	private int quantity;
	private int size;
	
	
	public Shoes()
	{
		
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public Shoes(int id, String color, String name, double price, int quantity, int size) {
		super();
		this.id = id;
		this.color = color;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
	}
	
	
	
	
	
	
	
	
	
	

}
