package com.demo.employee.exception;

public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 3291473686813059267L;

	public String message;

	public EmployeeException() {
		super();
	}

	public EmployeeException(String message) {
		super(message);
		this.message = message;
	}
}
