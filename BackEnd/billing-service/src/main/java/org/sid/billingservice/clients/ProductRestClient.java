package org.sid.billingservice.clients;

import javax.ws.rs.QueryParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import osg.sid.billingservice.models.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface ProductRestClient {

	@GetMapping("/products/{id}")
	Product findProductById(@PathVariable("id") Long id);
	
	@GetMapping("/products")
	PagedModel<Product> findAll();

}
