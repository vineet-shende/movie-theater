package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;


public interface DiscountService {
	
	Double getDiscount(Showing showing);
	
}
