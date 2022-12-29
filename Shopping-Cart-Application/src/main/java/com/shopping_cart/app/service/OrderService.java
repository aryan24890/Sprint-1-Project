package com.shopping_cart.app.service;

import java.util.List;
import java.util.Optional;

import com.shopping_cart.app.model.Order;
import com.shopping_cart.app.response.MessageResponse;

public interface OrderService {

	public List<Order> findAll();
	
	public MessageResponse save(Order order);
	
	public Optional<Order> getById(long id);
	
	public List<Order> getByStatus( boolean status);
	
	public List<Order> paging();
	
	public Iterable<Order> sorting(Order order);
	
	Order update(Order order) ;
	
	public MessageResponse deleteById(long id);

	public List<Order> findAllSortedByOrderDate();
}
