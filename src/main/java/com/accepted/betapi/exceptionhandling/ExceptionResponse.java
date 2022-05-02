package com.accepted.betapi.exceptionhandling;

public class ExceptionResponse {

	private String errorMessage;
	private String requestURI;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void callerURL(final String requestURI) {
		this.requestURI = requestURI;
	}

}
