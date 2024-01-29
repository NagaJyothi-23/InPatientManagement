package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerExceptionHandler {
	
//	@ExceptionHandler(value= RecordNotFoundException.class)
//	public ResponseEntity<String> handle(Exception ex)
//	{
//		System.out.println("handled");
//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//		
	//}
	
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<String> exception(RecordNotFoundException exception) {
		//log.error("ResourceNotFoundException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
