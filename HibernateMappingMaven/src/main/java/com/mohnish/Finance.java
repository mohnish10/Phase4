package com.mohnish;

public class Finance 
{
	
	private long financeId;
	private String name;
	private String ftype;
	
	
	public Finance()
	{
		
		super();
	}
	
	
	public Finance(String name,String ftype)
	{
		
		super();
		this.financeId = 0;
		this.name = name;
		this.ftype = ftype;
	}


	public long getFinanceId() {
		return financeId;
	}


	public void setFinanceId(long financeId) {
		this.financeId = financeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFtype() {
		return ftype;
	}


	public void setFtype(String ftype) {
		this.ftype = ftype;
	}



	
	
	
	
	
	
	
	
	
	
	
	

}
