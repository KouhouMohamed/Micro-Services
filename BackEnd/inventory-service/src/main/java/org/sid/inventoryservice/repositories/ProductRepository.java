package org.sid.inventoryservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import org.sid.inventoryservice.entities.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
	// url : .../find/byName?name=HP
	@RestResource(path="/byName")
	Page<Product> findByNameContains(@Param("name") String name, Pageable pageable);

}
