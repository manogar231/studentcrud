package com.springlearn.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentHandler() {
		super("Student Not Found ");
	}
		 
}
