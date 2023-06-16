package com.mohnish.springboot.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController 
{
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<Object> handleException(ProductNotFoundException ex)
	{
		
		return new ResponseEntity<Object>("Product not available with id 0",HttpStatus.NOT_FOUND);
	}

}
