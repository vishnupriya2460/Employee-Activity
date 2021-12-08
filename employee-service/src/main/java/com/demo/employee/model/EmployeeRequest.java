package com.demo.employee.model;

public class EmployeeRequest {

	private String name;

	private String jobTitle;

	private String emailId;

	private Integer experience;

	private Long phoneNumber;

	private String location;

	public EmployeeRequest(String name, String jobTitle, String emailId, Integer experience, Long phoneNumber,
			String location) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.emailId = emailId;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}

	public EmployeeRequest() {
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

}
