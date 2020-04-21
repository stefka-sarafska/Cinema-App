package com.swiftAcad.exceptions;

public class MovieException extends Exception {

	private String message;

	public MovieException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
