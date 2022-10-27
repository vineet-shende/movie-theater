package com.jpmc.theater.component.discount.impl;

import org.springframework.stereotype.Component;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.model.Showing;

@Component
public class SequenceDiscount implements Discount {

	/**
	 * Method for applying discount based on sequence of showing
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double applyDiscount(Showing showing) {
		System.out.println("Starting SequenceDiscount");
		Double sequenceDiscount = 0.0;
        if (showing.isSequence(1)) {
            sequenceDiscount = 3.0; // $3 discount for 1st show
        } else if (showing.isSequence(2)) {
        	sequenceDiscount = 2.0; // $2 discount for 2nd show
        }
        
        System.out.println("Ending SequenceDiscount: " + sequenceDiscount);
        return sequenceDiscount;
	}

}
