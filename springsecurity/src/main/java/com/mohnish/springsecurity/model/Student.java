package com.mohnish.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Student 
{
	
	private final Integer studentId;
	private final String studentName;
	
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
	
	
	
	
	
	

}
