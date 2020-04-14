package com.swiftAcad.exceptions;

public class HallException extends Exception {
	private String message;

	public HallException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
