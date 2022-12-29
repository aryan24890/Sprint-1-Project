package com.shopping_cart.app.exception;

public class ProductNotFoundException  extends Exception  {

	private static final long serialVersionUID = 1531865679710451637L;

	public ProductNotFoundException(String exception) {
		super(exception);
	}
}
