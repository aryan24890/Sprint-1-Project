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

import com.shopping_cart.app.exception.ProductLineNotFoundException;
import com.shopping_cart.app.model.ProductLine;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.ProductLineService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/productLines/")
public class ProductLineController {
	
	@Autowired
	private ProductLineService productLineService;
	
	//Find all ProductLines
	@GetMapping
	public List<ProductLine> getAllProductLine(){
		return productLineService.findAll();
	}
	
	
	//Add ProductLine
	@PostMapping("add")
	public MessageResponse createProductLine(@RequestBody ProductLine productLine) {
		return productLineService.save(productLine);
	}
	
	
	//Find By Id
	@GetMapping("find/{id}")
	public ResponseEntity<ProductLine> getProductLineById(@PathVariable  long id) throws ProductLineNotFoundException {
	        ProductLine productLine = productLineService.getById(id)
	                .orElseThrow(() -> new ProductLineNotFoundException ("ProductLine not exist with id:" + id));
	        
	        return ResponseEntity.ok(productLine );
	 }
	
	
	//Sort the ProductLine by name
    @GetMapping("sortbydescription")
    public List<ProductLine> findAllSortedByDescription(@RequestBody ProductLine productLinedetails) throws ProductLineNotFoundException {
        return productLineService.sortedByDescription(productLinedetails);
             
    }
	 
    
    //paging
    @GetMapping("/getbypage")
    public ResponseEntity<List<ProductLine>> getProductLines() throws ProductLineNotFoundException {
		List<ProductLine> list =productLineService.paging();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<ProductLine>>(productLineService.paging(), HttpStatus.OK);
	}
    
    
    //sorting
    @GetMapping("/getbysort")
	public List<ProductLine> getProductsbysort(@RequestBody ProductLine productLine) throws ProductLineNotFoundException {
		 
		  return (List<ProductLine>) productLineService.sorting(productLine);
            
	}
    
     //Update Product
	 @PutMapping("update/{id}")
	 public ProductLine updateProductLine(@RequestBody ProductLine productLine, @PathVariable long id) {
	  		
	    productLine.setProductLine(id);
			
		return productLineService.update(productLine);
		   
	 }	
	
	  
	 //Delete By Id
	  @DeleteMapping("delete/{id}")
	  public MessageResponse deleteProductLineById(@PathVariable long id) throws ProductLineNotFoundException {

		  productLineService.getById(id);
			 return productLineService.deleteById(id);
	  }
}