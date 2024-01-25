package com.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionHandler {
	
	@ExceptionHandler(value=PatientIdNotFoundException.class)
	
	    public ResponseEntity<String> handleIdNotFoundException() {
	        return new ResponseEntity("id not found",HttpStatus.NOT_FOUND);
	    }
	
 
}
