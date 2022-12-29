package com.shopping_cart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value = "SELECT * FROM customers ORDER BY Customer_Name",nativeQuery=true)
	public List<Customer> findAllSortedByName();
	
	@Query("from Customer" )
	public List<Customer> findCustomers(Pageable pageable);
	
	@Query("from Customer" )
	public Iterable<Customer> sortCustomer(Sort sort);
	
}