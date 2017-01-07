package com.study.infrastructure.exception;

public class DatabaseException extends Exception {
	
	public DatabaseException() {
		super();
	}
	
	public DatabaseException(String msg) {
		super(msg);
	}
	
	public DatabaseException(String msg, Throwable e) {
		super(msg, e);
	}

	public DatabaseException(Throwable e) {
		super(e);
	}
}
