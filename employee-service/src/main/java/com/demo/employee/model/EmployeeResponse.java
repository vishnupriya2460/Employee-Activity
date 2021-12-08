package com.demo.employee.model;

public class EmployeeResponse {

	private Integer code;

	private String name;

	private String jobTitle;

	private String emailId;

	private Integer experience;

	private Long phoneNumber;

	private String location;

	private String projectStatus;

	public EmployeeResponse(Integer code, String name, String jobTitle, String emailId, Integer experience,
			Long phoneNumber, String location, String projectStatus) {
		this.code = code;
		this.name = name;
		this.jobTitle = jobTitle;
		this.emailId = emailId;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.projectStatus = projectStatus;
	}

	public EmployeeResponse() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

}
