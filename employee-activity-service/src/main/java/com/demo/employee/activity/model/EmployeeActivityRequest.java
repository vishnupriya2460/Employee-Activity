package com.demo.employee.activity.model;

public class EmployeeActivityRequest {

	private String empName;

	private Integer code;

	private String description;

	private String status;

	public EmployeeActivityRequest(String empName, Integer code, String description, String status) {
		this.empName = empName;
		this.code = code;
		this.description = description;
		this.status = status;
	}

	public EmployeeActivityRequest() {
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

}
