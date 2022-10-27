package com.jpmc.theater.component.discount.impl;

import org.springframework.stereotype.Component;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.constants.DiscountConstants;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

@Component
public class SpecialDiscount implements Discount {

	/**
	 * Method for applying discount based on special movie code.
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double applyDiscount(Showing showing) {
		System.out.println("Starting SpecialDiscount");
		Double specialDiscount = 0.0;
		Movie currentMovie = showing.getMovie();
        if (DiscountConstants.MOVIE_CODE_SPECIAL == currentMovie.getSpecialCode()) {
        	// 20% discount for special movie
            specialDiscount = currentMovie.getTicketPrice() * 0.2;
        }
        
        System.out.println("Ending SpecialDiscount: " + specialDiscount);
        return specialDiscount;
	}

}
