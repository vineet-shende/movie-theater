package com.jpmc.theater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;
import com.jpmc.theater.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private DiscountService discountService;

	/**
	 * Method to get showing fee.
	 * @param showing Showing
	 * @return Double
	 */
	@Override
	public Double getShowingFee(Showing showing) {
		System.out.println("Starting to get showing fee for showing: " + showing);
		Double showingFee = showing.getMovie().getTicketPrice() - getDiscount(showing);
		if (showingFee <= 0.0) {
			return 0.0;
		}
		
		System.out.println("Returing showing fee: " + showingFee);
		return showingFee;
	}

	/**
	 * Method to get discount based on showing.
	 * @param showing Showing
	 * @return Double
	 */
	private Double getDiscount(Showing showing) {
		return discountService.getDiscount(showing);
	}

}
