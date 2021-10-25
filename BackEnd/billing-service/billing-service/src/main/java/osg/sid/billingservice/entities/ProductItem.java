package osg.sid.billingservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import osg.sid.billingservice.classes.Product;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductItem{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long productID;
	
	private double price; 
	
	private double quantity;
	
	@ManyToOne
	private Bill bill;
	
	@Transient 
	private Product product;
}
