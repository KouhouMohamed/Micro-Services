package org.sid.inventoryservice.projections;

import org.springframework.data.rest.core.config.Projection;

import org.sid.inventoryservice.entities.Product;

//  the web service sent just the data we need (name and price)
// the url : .../products?projection=mobile
@Projection(name="mobile", types=Product.class)
public interface ProductMobileProjection {
	String getName();
	double getPrice();

}
