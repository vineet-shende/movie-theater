package com.jpmc.theater.component.discount.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.constants.DiscountConstants;
import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;

public class SpecialDiscountTests {
	
	@InjectMocks
	private SpecialDiscount specialDiscount;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApplyDiscountForSpecialCodeMovie() {
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(9.0);
		showing.getMovie().setSpecialCode(DiscountConstants.MOVIE_CODE_SPECIAL);
		assertEquals(1.8, specialDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForNonSpecialCodeMovie() {
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(9.0);
		showing.getMovie().setSpecialCode(2);
		assertEquals(0.0, specialDiscount.applyDiscount(showing));
	}

}
