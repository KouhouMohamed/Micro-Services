package org.sid.billingservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import osg.sid.billingservice.models.Product;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double price;
	
	private int qte;
	
	private Long productId;
	
	@Transient
	private Product product;
	
	@ManyToOne
	private Bill bill;
}
