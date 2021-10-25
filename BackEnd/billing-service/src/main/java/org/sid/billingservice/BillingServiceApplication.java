package org.sid.billingservice;

import java.util.Collection;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.sid.billingservice.clients.CustomerRestClient;
import org.sid.billingservice.clients.ProductRestClient;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.models.Customer;
import org.sid.billingservice.models.Product;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BillRepository billRepository, 
				ProductItemRepository itemRepository
				) {
		return args -> {
			Bill bill = new Bill(null,new Date(),Long.valueOf(1),null,null);
			
			//Customer customer = customerRestClient.findCustomerById(1L);
			//Product prd = productRestClient.findProductById(1L);
			billRepository.save(bill);
			itemRepository.save(new ProductItem(null, 10, 1000,1L,null, bill));
			itemRepository.save(new ProductItem(null, 100, 500,2L,null, bill));
		};

	}
}
