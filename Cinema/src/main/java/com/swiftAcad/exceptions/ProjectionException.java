package com.swiftAcad.exceptions;

public class ProjectionException extends Exception{
	private String message;

	public ProjectionException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
