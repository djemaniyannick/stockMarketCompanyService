package com.codeimmig.yannick.exception;

public class CompanyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CompanyNotFoundException() {
		
	}
	
	public CompanyNotFoundException(String message) {
		super(message);
	}

}
