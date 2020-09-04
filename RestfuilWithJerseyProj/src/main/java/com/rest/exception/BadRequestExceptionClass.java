package com.rest.exception;

public class BadRequestExceptionClass extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BadRequestExceptionClass(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

}
