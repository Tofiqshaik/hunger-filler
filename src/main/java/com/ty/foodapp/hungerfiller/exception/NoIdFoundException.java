package com.ty.foodapp.hungerfiller.exception;

public class NoIdFoundException extends RuntimeException {
	
	private String message = "Given Id does not exist";
	
	public NoIdFoundException(){
		
	}
	public NoIdFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
