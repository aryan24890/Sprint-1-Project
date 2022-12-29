package com.shopping_cart.app.exception;

public class OrderNotFoundException extends Exception  {
	
	private static final long serialVersionUID = 8280115182401600685L;

	public  OrderNotFoundException(String exception) {
		super(exception);
	}
}
