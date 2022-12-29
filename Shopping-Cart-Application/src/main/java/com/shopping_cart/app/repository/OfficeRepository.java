package com.shopping_cart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.Office;


public interface OfficeRepository extends JpaRepository<Office, Long> {
	
	@Query(value = "SELECT * FROM offices  ORDER BY State",nativeQuery=true)
	public List<Office> findAllSortedByState();
	
	@Query(value="select * from Office  where City= ?", nativeQuery=true)
	public List<Office> findByCity(String city);
	
	
	@Query("from Office" )
	List<Office> findOffices(Pageable pageable);
	
	@Query("from Office" )
	public Iterable<Office> sortOffice(Sort sort);
}