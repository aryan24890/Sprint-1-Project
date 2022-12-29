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

import com.shopping_cart.app.exception.PaymentNotFoundException;
import com.shopping_cart.app.model.Payment;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.PaymentService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/payments/")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

		//Find all payment
		@GetMapping
		public List<Payment> getAllPayment(){
			return paymentService.findAll();
		}
	
		//Add payment
		@PostMapping("add")
		public MessageResponse createPayment(@RequestBody Payment payment) {
			return paymentService.save(payment);
		}
	
		
		//Find payment By Id
		@GetMapping("find/{id}")
		public ResponseEntity<Payment> getPaymentById(@PathVariable  long id) throws PaymentNotFoundException{
			Payment payment = paymentService.getById(id)
	                .orElseThrow(() -> new PaymentNotFoundException("Payment not exist with id:" + id));
	        
	        	return ResponseEntity.ok(payment );
		}
		
		
		 //Sort the Payment List by amount
	    @GetMapping("sortbyamount")
	    public List<Payment> findAllSortedByAmpunt(@RequestBody Payment paymentdetails) throws PaymentNotFoundException{
	        return paymentService.sortedByAmount(paymentdetails);
	             
	    } 
	    
	    //Get Payments records by page
	    @GetMapping("getbypage")
		public ResponseEntity<List<Payment>> getPayments() throws PaymentNotFoundException {
	     
			 List<Payment> list = paymentService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<Payment>>(paymentService.paging(), HttpStatus.OK);
		}
	    
	    
	    //sorting
	    @GetMapping("/getbysort")
		 public List<Payment> getPaymentsbysort(@RequestBody Payment payment) throws  PaymentNotFoundException {
			 
			  return (List<Payment>) paymentService.sorting(payment);
	             
		 }
	    
		
		//Update payment
		@PutMapping("update/{id}")
		public Payment updatePayment(@RequestBody Payment payment, @PathVariable long id) {
	    	payment.setCustomerNumber(id);
			
			return paymentService.update(payment);
		   
		}

		//Delete By Id 
		@DeleteMapping("delete/{id}")
		public MessageResponse deletePaymentById(@PathVariable long id) throws PaymentNotFoundException{

			paymentService.getById(id);
			 return paymentService.deleteById(id);
  	  }

	}
