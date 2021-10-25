package org.sid.billingservice.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import osg.sid.billingservice.models.Customer;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date billingDate;
	
	private Long customerID;
	
	@Transient
	private Customer customer;
	
	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> productItems;
}
