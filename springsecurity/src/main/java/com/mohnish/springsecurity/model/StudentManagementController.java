package com.mohnish.springsecurity.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController 
{
	
	private static final List<Student> STUDENTS = Arrays.asList(new Student(1,"Student 1"),new Student(2,"Student 2"),new Student(3,"Student 3"));
	
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudents()
	{
		
		return STUDENTS;
	}
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void registerNewStudent(@RequestBody Student student)
	{
		
		System.out.println(student);
		
	}
	
	
	@DeleteMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable("studentId") Integer studentId)
	{
		
		System.out.println(studentId);
	}
	
	
	@PutMapping(path="{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student)
	{
		
		System.out.printf("%s %s",studentId,student);
		
	}
	
	
	
	
	
	
	

}