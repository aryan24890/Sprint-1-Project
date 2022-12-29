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

import com.shopping_cart.app.exception.ProductNotFoundException;
import com.shopping_cart.app.model.Product;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.ProductService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
		//Find all
		@GetMapping
		public List<Product> getAllProducts(){
			return productService.findAll();
		}
		
		//Add Product
		@PostMapping("add")
		public MessageResponse createProduct(@RequestBody Product product) {
			return productService.save(product);
		}
		
		
		//Find By Id
	    @GetMapping("find/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable  long id) throws ProductNotFoundException {
	        Product product = productService.getById(id)
	                .orElseThrow(() -> new ProductNotFoundException ("Product not exist with id :" + id));
	        
	        return ResponseEntity.ok(product);
	    }
	    
	    
	  //Find by product name
	    @GetMapping("find/{productName}")
	    public ResponseEntity<List<Product>> findByProductName(@PathVariable  String productName){
	    	  List<Product> products = productService.getByName(productName);

	    	    if ( products.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }
	    	    
	    	    return new ResponseEntity<>( products, HttpStatus.OK);
	    }
	    
	    
	    //Paging
	    @GetMapping("getbypage")
	    public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
			
	    	List<Product> list = productService.paging();
			
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<List<Product>>(productService.paging(), HttpStatus.OK);
		}
	    
	    
	    //sorting
	    @GetMapping("getbysort")
		 public List<Product> getProductsbysort(@RequestBody Product product) throws ProductNotFoundException {
			 
			  return (List<Product>) productService.sorting(product);      
		  }
	        
	    
	    //Update Product
	    @PutMapping("update/{id}")
	  	public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
	  		
	    		product.setProductCode(id);
	  			
	    		return productService.update(product);		   
	    }	
	    
	    
	    //Delete By Id
	    @DeleteMapping("delete/{id}")
	    public MessageResponse deleteByProductId(@PathVariable long id) throws ProductNotFoundException {

	    	productService.getById(id);
			 return productService.deleteById(id);
  	  	 }
}
