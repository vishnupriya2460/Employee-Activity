package com.demo.employee.activity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.activity.entity.EmployeeActivity;

public interface EmployeeActivityRepository extends JpaRepository<EmployeeActivity, Integer> {

	List<EmployeeActivity> findBycode(Integer code);

	EmployeeActivity findBycodeAndStatus(Integer code, String status);
	
	void deleteBycode(Integer code);
}
