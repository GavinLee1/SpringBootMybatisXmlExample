package com.study.infrastructure.exception;

public class ValueObjectIsInvalidException extends Exception{
	
	public ValueObjectIsInvalidException(String msg) {
		super(msg);
	}
	
	public ValueObjectIsInvalidException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
