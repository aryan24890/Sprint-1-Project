package com.shopping_cart.app.exception;

public class PaymentNotFoundException extends Exception  {
	
	private static final long serialVersionUID = 933958641037794250L;

	public  PaymentNotFoundException(String exception) {
		super(exception);
	}
}
