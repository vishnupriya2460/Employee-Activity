package com.demo.employee.activity.model;

import java.util.List;

public class EmployeeActivityResponseList {

	private EmployeeResponse employeeResponse;
	private List<EmployeeActivityResponse> employeeActivityResponse;

	public EmployeeActivityResponseList(EmployeeResponse employeeResponse,
			List<EmployeeActivityResponse> employeeActivityResponse) {
		this.employeeResponse = employeeResponse;
		this.employeeActivityResponse = employeeActivityResponse;
	}

	public EmployeeActivityResponseList() {
	}

	public EmployeeResponse getEmployeeResponse() {
		return employeeResponse;
	}

	public void setEmployeeResponse(EmployeeResponse employeeResponse) {
		this.employeeResponse = employeeResponse;
	}

	public List<EmployeeActivityResponse> getEmployeeActivityResponse() {
		return employeeActivityResponse;
	}

	public void setEmployeeActivityResponse(List<EmployeeActivityResponse> employeeActivityResponse) {
		this.employeeActivityResponse = employeeActivityResponse;
	}

}
