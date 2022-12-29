package com.shopping_cart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//native query
	@Query(value = "SELECT * FROM Products  WHERE Product_Name =?",nativeQuery=true)
	List<Product> findByProductName(String productName);
	
	
	@Query(value = "SELECT p FROM Product p ORDER BY Buy_Price")
	public List<Product> findAllSortedByPrice();		  
	   
	@Query("from Product" )
	List<Product> findProducts(Pageable pageable);
	
	@Query("from Product" )
	public Iterable<Product> sortProduct(Sort sort);
	   

} 