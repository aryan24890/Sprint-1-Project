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

import com.shopping_cart.app.exception.OrderDetailNotFoundException;
import com.shopping_cart.app.model.OrderDetail;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.OrderDetailService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orderDetails/")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
		//Find all
		@GetMapping
		public List<OrderDetail> getAllorderDetail(){
			return orderDetailService.findAll();
		}
	
		
		//Add OrderDetail
		@PostMapping("add")
		public MessageResponse createOrderDetail(@RequestBody OrderDetail orderDetail) {
			return orderDetailService.save(orderDetail);
		}
	 
		
		//Find By Id
		@GetMapping("find/{id}")
		public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable  long id) throws OrderDetailNotFoundException{
			OrderDetail orderDetail = orderDetailService.getById(id)
	                .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + id));
	        
			return ResponseEntity.ok(orderDetail);
		}
		
		
		//Sort the Order List by date
	    @GetMapping("sortbyprice")
	    public List<OrderDetail> findAllSortedByPrice(@RequestBody  OrderDetail  orderDetails) throws OrderDetailNotFoundException{
	        return orderDetailService.findAllSortedByPrice();
	             
	    }

	    
	    //paging
	    @GetMapping("getbypage")
		public ResponseEntity<List<OrderDetail>> getOrderDetails() throws OrderDetailNotFoundException {
	    	 List<OrderDetail> list =orderDetailService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<OrderDetail>>(orderDetailService.paging(), HttpStatus.OK);
		}
		 
	    
	    //sorting
	    @GetMapping("getbysort")
		 public List<OrderDetail> getOrderDetailsbysort(@RequestBody OrderDetail orderDetail) throws OrderDetailNotFoundException {
			 
			  return (List<OrderDetail>) orderDetailService.sorting(orderDetail);
	             
		 }
	    
	    
		//Update orderDetail
		@PutMapping("update/{id}")
		public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable long id) {
	  		
	    	orderDetail.setQuantityOrdered(id);
			
			return orderDetailService.update(orderDetail);
		   
		}

		
		//Delete By id
		@DeleteMapping("delete/{id}")
		public MessageResponse deleteOrderDetailById(@PathVariable long id) throws OrderDetailNotFoundException{

			orderDetailService.getById(id);
			return orderDetailService.deleteById(id);
		}
	
}
