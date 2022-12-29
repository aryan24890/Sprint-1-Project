package com.shopping_cart.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.shopping_cart.app.exception.EmployeeNotFoundException;
import com.shopping_cart.app.model.Employee;
import com.shopping_cart.app.response.MessageResponse;
import com.shopping_cart.app.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
		//Find all Employee
		@GetMapping
		public List<Employee> getAllEmployee(){
			return employeeService.findAll();
		}
	
		//Add employee
		@PostMapping("add")
		public MessageResponse createEmployee(@RequestBody Employee employee) {
			return employeeService.save(employee);
		}
	
		//Find employee By Id
		@GetMapping("find/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id) throws EmployeeNotFoundException{
			Employee employee = employeeService.getById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id:" + id));
				
			return ResponseEntity.ok(employee);
		}
		
		//Sort the Employee List by email
	    @GetMapping("sortbyemail")
	    public List<Employee> findAllSortedByEmail(@RequestBody Employee  employeesDetails) throws EmployeeNotFoundException{
	        return employeeService.findAllSortedByEmail(employeesDetails);
	             
	    }
	    
	    //search employee by first name
	    @GetMapping("find/{firstName}")
		public ResponseEntity<List<Employee>> findEmployeeByFirstName(@PathVariable String firstName){
			List<Employee> employee = employeeService.findByFirstName(firstName);
			
			if(employee == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(employee));
		}
	    
		//Update Employee
		@PutMapping("update/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee  employeesDetails) throws EmployeeNotFoundException {
		
		 Employee  updateEmployee  =  employeeService.getById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id: " + id));
		 
		 updateEmployee.setEmployeenumber(id); 
		
		 employeeService.save(updateEmployee);
	     	
		 return ResponseEntity.ok(updateEmployee);
		}

		//Delete By id 
		@DeleteMapping("delete/{id}")
		public MessageResponse deleteEmployeeById(@PathVariable long id) throws EmployeeNotFoundException{

			employeeService.getById(id);
				 return employeeService.deleteById(id);
	  	  }
}
