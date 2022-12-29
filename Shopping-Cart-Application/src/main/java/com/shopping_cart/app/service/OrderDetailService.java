package com.shopping_cart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shopping_cart.app.model.OrderDetail;
import com.shopping_cart.app.response.MessageResponse;

@Component
public interface OrderDetailService {

	public List<OrderDetail> findAll();
	
	public MessageResponse save(OrderDetail orderDetails);
	
	public Optional<OrderDetail> getById(long id);
	
	//public List<OrderDetail> orderDetailService(double priceEach);
	
	public List<OrderDetail> paging();
	
	public Iterable<OrderDetail> sorting(OrderDetail orderDetails);
	
	OrderDetail update(OrderDetail orderDetails) ;
	
	public MessageResponse deleteById(long id);

	public List<OrderDetail> findAllSortedByPrice();
}
