package com.shopping_cart.app.repository;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping_cart.app.model.ProductLine;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {
	
	//native query
	@Query(value = "SELECT * FROM productlines ORDER BY text_Description",nativeQuery=true)
	public List<ProductLine> findAllSortedByDescription();

	@Query("from ProductLine" )
	List<ProductLine> findProductLines(Pageable pageable);
	
	@Query("from ProductLine" )
	public Iterable<ProductLine> sortProductLine(Sort sort);
}
