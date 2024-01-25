package com.admin.exception;

public class RecordNotFoundException extends RuntimeException{

	public RecordNotFoundException(String message) {
		super(message);
	}
	public RecordNotFoundException(String message, Exception exception) {
		super(message, exception);
	}
	

}
