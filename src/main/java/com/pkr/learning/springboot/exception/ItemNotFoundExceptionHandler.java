package com.pkr.learning.springboot.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemNotFoundExceptionHandler {

	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<Object> exception() {
		Map<String, Object> body = new HashMap<>();
		body.put("message", "Item Not Found");
		body.put("Time", new Date());
		body.put("Status", "Failed");
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND); // in place of body you can directly put String message
	}
}
