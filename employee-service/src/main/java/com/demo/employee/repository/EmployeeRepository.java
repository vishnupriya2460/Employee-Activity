package com.demo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findBycode(Integer code);

	Employee findByEmailId(String emailId);
	
	void deleteBycode(Integer code);
}
