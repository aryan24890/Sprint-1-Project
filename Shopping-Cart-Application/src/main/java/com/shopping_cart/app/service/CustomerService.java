package com.shopping_cart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shopping_cart.app.model.Customer;
import com.shopping_cart.app.response.MessageResponse;

@Component
public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public MessageResponse save(Customer customer);
	
	public Optional<Customer> getById(long id);
	
	public List<Customer> sortedByName(Customer customerdetails);
	
	public List<Customer> paging();
	
	public Iterable<Customer> sorting(Customer customerdetails);
	
	public MessageResponse deleteById(long id);
	
	Customer update(Customer customer) ;
}
