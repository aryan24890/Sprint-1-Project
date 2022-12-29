package com.shopping_cart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_cart.app.exception.OrderNotFoundException;
import com.shopping_cart.app.model.Order;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.OrderService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orders/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
		//Find All
		@GetMapping
		public List<Order> getAllOrder(){
			return orderService.findAll();
		}
	
		//Add Order
		@PostMapping("add")
		public MessageResponse createOrder(@RequestBody Order order) {
			return orderService.save(order);
		}
	
		//Find By Id
		@GetMapping("find/{id}")
		public ResponseEntity<Order> getOrderById(@PathVariable  long id) throws OrderNotFoundException{
			Order order = orderService.getById(id)
	                .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + id));
	            return ResponseEntity.ok(order );    
		}
		
		//Sort the Order List by date
	    @GetMapping("sortbydate")
	    public List<Order> findAllSortedByOrderDate(@RequestBody  Order  orderDetails) throws OrderNotFoundException{
	        return orderService.findAllSortedByOrderDate();
	             
	    }
	    
	  //Get Orders records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<Order>> getOrders() throws OrderNotFoundException {
	    
			 List<Order> list = orderService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<Order>>(orderService.paging(), HttpStatus.OK);
		}
	    
	    
	    //sorting
	    @GetMapping("/getbysort")
		 public List<Order> getOrdersbysort(@RequestBody Order order) throws OrderNotFoundException {
			 
			  return (List<Order>) orderService.sorting(order);
	             
		 }
		
	    
		//Update Order
		@PutMapping("update/{id}")
	  	public Order updateOrder(@RequestBody Order order, @PathVariable long id) {
	    	order.setOrderNumber(id);
	  		return orderService.update(order);
	    }
	   
		//Delete By Id
		@DeleteMapping("delete/{id}")
		public MessageResponse deleteOrderById(@PathVariable long id) throws OrderNotFoundException{
			
			orderService.getById(id);
			 return orderService.deleteById(id);
		}
	}