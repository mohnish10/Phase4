package com.mohnish;

public class Color 
{
	
	private long colorId;
	private String name;
	
	
	public Color()
	{
		
		super();
	}
	
	
	public Color(String name)
	{
		
		super();
		this.colorId = 0;
		this.name = name;
	}


	


	@Override
	public String toString() {
		return "Color [colorId=" + colorId + ", name=" + name + "]";
	}


	public long getColorId() {
		return colorId;
	}


	public void setColorId(long colorId) {
		this.colorId = colorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
