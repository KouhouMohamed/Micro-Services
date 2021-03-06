package org.sid.billingservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import osg.sid.billingservice.models.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
	
	@GetMapping("/customers/{id}")
	Customer findCustomerById(@PathVariable("id") Long id);
}
