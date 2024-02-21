package com.interview.invacare.common;

public class DataNotFoundException extends Exception {

	private String message;

	public DataNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
