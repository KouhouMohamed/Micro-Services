package org.sid.billingservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.sid.billingservice.entities.ProductItem;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
	
	List<ProductItem> findByBillId(Long id);
}
