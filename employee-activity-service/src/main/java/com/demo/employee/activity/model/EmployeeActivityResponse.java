package com.demo.employee.activity.model;

import java.time.LocalDateTime;

public class EmployeeActivityResponse {

	private String empName;

	private Integer code;

	private String description;

	private String status;

	private LocalDateTime date;

	public EmployeeActivityResponse(String empName, Integer code, String description, String status,
			LocalDateTime date) {
		this.empName = empName;
		this.code = code;
		this.description = description;
		this.status = status;
		this.date = date;
	}

	public EmployeeActivityResponse() {
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	 
}
