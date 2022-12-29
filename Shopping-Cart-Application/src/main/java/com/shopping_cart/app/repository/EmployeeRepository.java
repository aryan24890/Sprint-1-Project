package com.shopping_cart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "SELECT e FROM Employee e ORDER BY Email")
	public List<Employee> findAllSortedByEmail();
	
	//native query
	@Query(value="select * from employees where first_name= ?", nativeQuery=true)
	public List<Employee> findByFirstName(String firstName);
	
	@Query("from Employee" )
	List<Employee> findEmployees(Pageable pageable);
	
	@Query("from Employee" )
	public Iterable<Employee> sortEmployee(Sort sort);
}