package org.sid.billingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.sid.billingservice.clients.CustomerRestClient;
import org.sid.billingservice.clients.ProductRestClient;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;

@RestController
public class BillRestController {
	
	@Autowired private BillRepository billRepository;
	@Autowired private ProductItemRepository itemRepository;
	@Autowired private ProductRestClient productRestClient;
	@Autowired private CustomerRestClient customerRestClient;
	
	@GetMapping(path="/bills/full/{id}")
	Bill getBill(@PathVariable(name="id") Long id) {
		Bill bill = billRepository.findById(id).get();
		
		bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerID()));
		bill.setProductItems(itemRepository.findByBillId(id));
		
		bill.getProductItems().forEach(pi ->{
			pi.setProduct(productRestClient.findProductById(pi.getProductId()));
		});
		
		return bill;
	}

}
