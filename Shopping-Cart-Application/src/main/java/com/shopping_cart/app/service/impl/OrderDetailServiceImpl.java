package com.shopping_cart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.shopping_cart.app.model.OrderDetail;
import com.shopping_cart.app.repository.OrderDetailRepository;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository  orderDetailRepository ;

	@Override
	public List<OrderDetail> findAll() {
			return orderDetailRepository.findAll();
	}

	@Override
	public MessageResponse save(OrderDetail orderDetails) {
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setQuantityOrdered(orderDetails.getQuantityOrdered());
		orderDetail.setPriceEach(orderDetails.getPriceEach());
		orderDetail.setOrderLineNumber(orderDetails.getOrderLineNumber());
		
		orderDetailRepository.save(orderDetail);
		
		return new MessageResponse("New orderDetail  record created successfully");

	}
			

	@Override
	public Optional<OrderDetail> getById(long id) {
		return orderDetailRepository.findById(id);
		
		}
	


	@Override
	public List<OrderDetail> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<OrderDetail> list = orderDetailRepository.findOrderDetails(pageable);
		return list;
	}

	@Override
	public Iterable<OrderDetail> sorting(OrderDetail orderDetails) {
		String sortBy = "Price_Each";
		List<OrderDetail> list = (List<OrderDetail>) orderDetailRepository.sortOrderDetail(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

	@Override
	public OrderDetail update(OrderDetail orderDetails) {
		return orderDetailRepository.save(orderDetails);
	}

	@Override
	public MessageResponse deleteById(long id) {
		orderDetailRepository.findById(id);
		 
		orderDetailRepository.deleteById(id);
			 
		 return new MessageResponse("orderDetailRepository record deleted successfully");

		}

	@Override
	public List<OrderDetail> findAllSortedByPrice() {
		return orderDetailRepository.findAllSortedByPrice();
	}

}
