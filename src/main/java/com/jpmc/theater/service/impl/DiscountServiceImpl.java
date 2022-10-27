package com.jpmc.theater.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired(required = false)
	private List<Discount> discountList;
	
	/**
	 * Method to get discount based on showing.
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double getDiscount(Showing showing) {
		System.out.println("Starting to get discount");
		
		Double maxDiscount = 0.0;
		if (discountList != null && !discountList.isEmpty()) {
			for (Discount discount: discountList) {
				maxDiscount = Math.max(maxDiscount, discount.applyDiscount(showing));
			}
		}
		
		System.out.println("Got max discount: " + maxDiscount);
		return maxDiscount;
    }
	
}
