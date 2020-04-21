package com.swiftAcad.exceptions;

public class CinemaException extends Exception {
	private String message;

	public CinemaException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
