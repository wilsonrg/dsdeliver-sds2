package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	@Query("select distinct obj from Order obj join fetch obj.products "
		+ " Where obj.status =0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();
	
}
