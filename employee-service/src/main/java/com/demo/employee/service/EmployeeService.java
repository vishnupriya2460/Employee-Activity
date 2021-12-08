package com.demo.employee.service;

import com.demo.employee.model.EmployeeActivityResponseList;
import com.demo.employee.model.EmployeeRequest;
import com.demo.employee.model.EmployeeResponse;
import com.demo.employee.model.ProjectStatus;

public interface EmployeeService {

	EmployeeResponse createEmployee(EmployeeRequest request);
	
	String createEmployeeWithMessage(EmployeeRequest request);

	EmployeeActivityResponseList getEmployeeWithActivity(Integer code);

	EmployeeResponse getEmployee(Integer code);

	EmployeeResponse updateProjectStatus(ProjectStatus projectStatus);

	void deleteEmployee(Integer code);

	String getInfo();
}
