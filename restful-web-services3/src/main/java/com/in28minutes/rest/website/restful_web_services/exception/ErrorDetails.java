package com.in28minutes.rest.website.restful_web_services.exception;

import java.time.LocalDate;

public class ErrorDetails {
	private LocalDate timeStamp;
	private String ErrorMessage;
	private String details;

	public ErrorDetails(LocalDate timeStamp, String errorMessage, String details) {
		this.timeStamp = timeStamp;
		ErrorMessage = errorMessage;
		this.details = details;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public String getDetails() {
		return details;
	}
	
}

