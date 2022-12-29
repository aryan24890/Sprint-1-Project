package com.shopping_cart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shopping_cart.app.model.Employee;
import com.shopping_cart.app.response.MessageResponse;

@Component
public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public MessageResponse save(Employee employee);
	
	public Optional<Employee> getById(long id);
	
	public List<Employee> findAllSortedByEmail(Employee employeedetails);
	
	public List<Employee> findByFirstName(String firstName);
	
	public List<Employee> paging();
	
	public Iterable<Employee> sorting(Employee employeedetails);
	
	Employee update(Employee employee) ;
	
	public MessageResponse deleteById(long id);
}
