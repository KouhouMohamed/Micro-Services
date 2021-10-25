package org.sid.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;

//@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping(path="/customers",
				produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	@GetMapping(path = "/customers/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer getOne(@PathVariable Long id) {
		return customerRepository.findById(id).get();
	}
	
	@PostMapping(path = "/customers/new-customer",
			consumes = { MediaType.APPLICATION_JSON_VALUE, "multipart/form-data" }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer addOne(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@PutMapping(path = "/customers/update-customer/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer updateOne(@PathVariable Long id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerRepository.save(customer);
	}
	
	@DeleteMapping(path = "/customers/delete-customer/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteOne(@PathVariable Long id) {
		
		customerRepository.deleteById(id);
	}
	
}
