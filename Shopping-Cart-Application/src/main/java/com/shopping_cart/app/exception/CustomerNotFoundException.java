package com.shopping_cart.app.exception;

public class CustomerNotFoundException  extends Exception {
	
	private static final long serialVersionUID = -8109095457284077938L;

	public CustomerNotFoundException(String exception) {
		super(exception);
	}
}
