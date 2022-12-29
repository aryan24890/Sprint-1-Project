package com.shopping_cart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopping_cart.app.model.Order;
import com.shopping_cart.app.repository.OrderRepository;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public MessageResponse save(Order order) {

		Order newOrder = new Order();
		newOrder.setOrderDate(order.getOrderDate());
		newOrder.setRequiredDate(order.getRequiredDate());
		newOrder.setShippedDate(order.getShippedDate());
		newOrder.setStatus(order.isStatus());
		newOrder.setComments(order.getComments());
		orderRepository.save(newOrder);
		
		return new MessageResponse("New Order record created successfully");

	}

	@Override
	public Optional<Order> getById(long id) {
		return orderRepository.findById(id);
	
		}

	@Override
	public List<Order> getByStatus(boolean status) {
		return  orderRepository.findByTrueStatus();
	}

	@Override
	public List<Order> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Order> list =orderRepository.findOrders(pageable);
		return list;
	}

	@Override
	public Iterable<Order> sorting(Order order) {
		String sortBy = "order_number";
		List<Order> list = (List<Order>) orderRepository.sortOrder(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}


	@Override
	public Order update(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public MessageResponse deleteById(long id) {
		orderRepository.findById(id);
		 
		orderRepository.deleteById(id);
			 
		return new MessageResponse("Order record deleted successfully");

		 }

	@Override
	public List<Order> findAllSortedByOrderDate() {
		return orderRepository.findAllSortedByOrderDate();
	}

}
