package com.shopping_cart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	//native query
	@Query(value = "SELECT * FROM payments ORDER BY Amount",nativeQuery=true)
	public List<Payment> findAllSortedByAmount();
	
	@Query("from Payment" )
	List<Payment> findPayments(Pageable pageable);
	
	@Query("from Payment" )
	public Iterable<Payment> sortPayment(Sort sort);
}