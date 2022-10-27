package com.jpmc.theater.component.discount;

import com.jpmc.theater.model.Showing;

public interface Discount {
	
	Double applyDiscount(Showing showing);
}
