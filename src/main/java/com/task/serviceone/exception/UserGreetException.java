package com.task.serviceone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserGreetException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2054289003892239800L;

	public UserGreetException(String msg) {
		super(msg);
	}
}
