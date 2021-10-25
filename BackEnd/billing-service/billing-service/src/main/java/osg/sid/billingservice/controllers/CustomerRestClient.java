package osg.sid.billingservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.cloud.openfeign.FeignClient;
import osg.sid.billingservice.classes.Customer;

@FeignClient(name="customer-service")
public interface CustomerRestClient{
	@GetMapping("/customers/{id}?projection=fullCustomer")
	Customer findCustomerById(@PathVariable("id") Long id);
}
