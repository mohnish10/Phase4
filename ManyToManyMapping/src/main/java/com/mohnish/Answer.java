package com.mohnish;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ans1123")
public class Answer 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String answerName;
	private String postedBy;
	
	
	public int getId()
	{
		
		return id;
	}
	
	
	public void setId(int id)
	{
		
		this.id = id;
	}
	
	
	public String getAnswerName()
	{
		
		return answerName;
	}
	
	
	public void setAnswerName(String answerName)
	{
		
		this.answerName = answerName;
	}
	
	
	public String getPostedBy()
	{
		
		return postedBy;
	}
	
	
	public void setPostedBy(String postedBy)
	{
		
		this.postedBy = postedBy;
	}
	
	
	
	
	
	
	

}
