package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface RestRepository extends JpaRepository<Product, Long> {
	
	  @Query(value="select * from Products u where u.ProductName = ?1 ", nativeQuery = true)
	  Product findByEProductName(String ProductName);
	  @Query(value="select * from Products u where u.Price = ?1 or u.ProductName = ?2 or u.ProductCode=?3", 
			  nativeQuery = true)
	  Product findCustom(String Price, String ProductName, String ProductCode);
}
