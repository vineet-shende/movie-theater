package com.jpmc.theater.component.discount.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;

public class StartTimeDiscountTests {
	
	@InjectMocks
	private StartTimeDiscount startTimeDiscount;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApplyDiscountForMovieStartTimeBetween11AMAnd4PM() {
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(9.0);
		showing.setShowStartTime(LocalDateTime.of(2022, 11, 7, 12, 30));
		assertEquals(2.25, startTimeDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForMovieStartTimeLessThan11AM() {
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(9.0);
		showing.setShowStartTime(LocalDateTime.of(2022, 11, 7, 10, 30));
		assertEquals(0.0, startTimeDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForMovieStartTimeGreaterThan4PM() {
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(9.0);
		showing.setShowStartTime(LocalDateTime.of(2022, 11, 7, 17, 30));
		assertEquals(0.0, startTimeDiscount.applyDiscount(showing));
	}

}
