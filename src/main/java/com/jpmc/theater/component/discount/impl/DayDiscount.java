package com.jpmc.theater.component.discount.impl;

import org.springframework.stereotype.Component;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.constants.DiscountConstants;
import com.jpmc.theater.model.Showing;

@Component
public class DayDiscount implements Discount {

	/**
	 * Method for applying discount based on day of the month.
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double applyDiscount(Showing showing) {
		System.out.println("Starting DayDiscount");
		Double dayDiscount = 0.0;
        if (showing.getShowStartTime().getDayOfMonth() == DiscountConstants.DAY_OF_MONTH_7Th) {
        	dayDiscount = 1.0; // $1 discount for 7th day
        }
        
        System.out.println("Ending DayDiscount: " + dayDiscount);
        return dayDiscount;
	}

}
