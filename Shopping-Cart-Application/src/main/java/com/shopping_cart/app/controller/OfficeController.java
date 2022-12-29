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

import com.shopping_cart.app.exception.OfficeNotFoundException;
import com.shopping_cart.app.model.Office;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.OfficeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/offices/")
public class OfficeController {
	
	@Autowired
	private OfficeService officeService;
	
		
		//Find all office
		@GetMapping
		public List<Office> getAllOffice(){
			return officeService.findAll();
		}
	
		
		//Add office
		@PostMapping("add")
		public MessageResponse createOffice(@RequestBody Office office) {
			return officeService.save(office);
		}
	
		
		//Find by Id
		@GetMapping("find/{id}")
		public ResponseEntity<Office> getOfficeById(@PathVariable  long id) throws OfficeNotFoundException{
			Office office = officeService.getById(id)
	                .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + id));        
			return ResponseEntity.ok(office);	
		}
		
		
		//Sort the Employee List by email
	    @GetMapping("sortbystate")
	    public List<Office> findAllSortedByState(@RequestBody  Office  officeDetails) throws OfficeNotFoundException{
	        return officeService.sortedByState(officeDetails);        
	    }
	    
	    //Get offices records by page
	    @GetMapping("getbypage")
		public ResponseEntity<List<Office>> getOffices() throws OfficeNotFoundException {
	     
			 List<Office> list = officeService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				
				return new ResponseEntity<List<Office>>(officeService.paging(), HttpStatus.OK);
		}
	    
	    
	    //sorting
	    @GetMapping("getbysort")
		 public List<Office> getOfficesbysort(@RequestBody Office officedetails) throws OfficeNotFoundException {
			 
			  return (List<Office>) officeService.sorting(officedetails);       
		 }


		//Update office
		@PutMapping("update/{id}")
		public Office updateOffice(@RequestBody Office office, @PathVariable long id) {
	  		
  			office.setOfficeCode(id);
  			
  			return officeService.update(office);
		}

		
		//Delete By Id 
		@DeleteMapping("delete/{id}")
		public MessageResponse deleteOfficeById(@PathVariable long id) throws OfficeNotFoundException{

			officeService.getById(id);
			 return officeService.deleteById(id);
		}
}
