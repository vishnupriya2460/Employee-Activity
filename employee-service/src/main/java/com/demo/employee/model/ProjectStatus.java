package com.demo.employee.model;

public class ProjectStatus {

	private String projectStatus;
	private Integer code;

	
	
	public ProjectStatus() {
	}

	public ProjectStatus(String projectStatus, Integer code) {
		this.projectStatus = projectStatus;
		this.code = code;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
