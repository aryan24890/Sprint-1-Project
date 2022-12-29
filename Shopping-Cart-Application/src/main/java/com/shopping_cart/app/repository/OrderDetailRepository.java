package com.shopping_cart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
	//native query
	@Query(value = "SELECT * FROM orderdetails  ORDER BY Price_Each",nativeQuery=true)
	public List<OrderDetail> findAllSortedByPrice();
	 
	@Query("from OrderDetail" )
	List<OrderDetail> findOrderDetails(Pageable pageable);
	
	@Query("from OrderDetail" )
	public Iterable<OrderDetail> sortOrderDetail(Sort sort);

}
