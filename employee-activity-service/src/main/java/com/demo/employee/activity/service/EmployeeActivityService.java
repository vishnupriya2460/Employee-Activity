package com.demo.employee.activity.service;

import java.util.List;

import com.demo.employee.activity.model.EmployeeActivityRequest;
import com.demo.employee.activity.model.EmployeeActivityResponse;
import com.demo.employee.activity.model.EmployeeActivityResponseList;

public interface EmployeeActivityService {

	EmployeeActivityResponse createEmployeeActivity(EmployeeActivityRequest request);

	EmployeeActivityResponseList getEmployeeActivity(Integer code);
	
	List<EmployeeActivityResponse> getAllEmployeeActivity(Integer code);
	
	void deleteEmployeeActivity(Integer code);

}
