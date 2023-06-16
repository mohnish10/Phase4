package com.mohnish.Simple.Employee.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.Simple.Employee.Management.System.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> 
{
	
	
	

}
