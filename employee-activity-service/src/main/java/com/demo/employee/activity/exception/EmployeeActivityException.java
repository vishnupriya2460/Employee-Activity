package com.demo.employee.activity.exception;

public class EmployeeActivityException extends RuntimeException {

	private static final long serialVersionUID = 3291473686813059267L;

	public String message;

	public EmployeeActivityException() {
		super();
	}

	public EmployeeActivityException(String message) {
		super(message);
		this.message = message;
	}
}
