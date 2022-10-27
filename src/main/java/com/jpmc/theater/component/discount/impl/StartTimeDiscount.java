package com.jpmc.theater.component.discount.impl;

import org.springframework.stereotype.Component;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.constants.DiscountConstants;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

@Component
public class StartTimeDiscount implements Discount {

	/**
	 * Method for applying discount based on movie start time.
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double applyDiscount(Showing showing) {
		System.out.println("Starting StartTimeDiscount");
		Double startTimeDiscount = 0.0;
		Movie currentMovie = showing.getMovie();
        if (showing.getShowStartTime().getHour() >= DiscountConstants.TIME_11_AM 
        		&& showing.getShowStartTime().getHour() <= DiscountConstants.TIME_4_PM) {
        	// 25% discount for show start time between 11am - 4pm
        	startTimeDiscount = currentMovie.getTicketPrice() * .25;
        }
        
        System.out.println("Ending StartTimeDiscount: " + startTimeDiscount);
        return startTimeDiscount;
	}

}
