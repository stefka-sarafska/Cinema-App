package com.swiftAcad.exceptions;

public class DateException extends Exception{
	private String message;

	public DateException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
