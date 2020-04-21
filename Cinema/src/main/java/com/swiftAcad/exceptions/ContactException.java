package com.swiftAcad.exceptions;

public class ContactException extends Exception {
	private String message;

	public ContactException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}

}
