package com.shopping_cart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shopping_cart.app.model.Payment;
import com.shopping_cart.app.response.MessageResponse;

@Component
public interface PaymentService {

	public List<Payment> findAll();
	
	public MessageResponse save(Payment payment);
	
	public Optional<Payment> getById(long id);
	
	public List<Payment> sortedByAmount(Payment payment);
	
	public List<Payment> paging();
	
	public Iterable<Payment> sorting(Payment payment);
	
	Payment update(Payment payment) ;
	
	public MessageResponse deleteById(long id);
	
}
