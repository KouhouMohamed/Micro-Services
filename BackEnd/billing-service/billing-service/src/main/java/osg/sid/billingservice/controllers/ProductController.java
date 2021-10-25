package osg.sid.billingservice.controllers;

import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import osg.sid.billingservice.classes.Product;

@FeignClient(name="inventory-service")
interface InventoryServiceClient{
	
	@GetMapping("/products/{id}?projection=fullProduct")
	Product findProductById(@PathVariable("id") Long id);
	
	@GetMapping("/products?projection=fullProduct")
	PagedModel<Product> findAll();
}

