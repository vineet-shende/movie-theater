package com.jpmc.theater.component.discount.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;

public class DayDiscountTests {
	
	@InjectMocks
	private DayDiscount dayDiscount;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApplyDiscountFor7ThDayOfMonth() {
		Showing showing = Mocks.getMockShowing();
		showing.setShowStartTime(LocalDateTime.of(2022, 11, 7, 12, 30));
		assertEquals(1.0, dayDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForAnyDayOfMonthExcept7Th() {
		Showing showing = Mocks.getMockShowing();
		showing.setShowStartTime(LocalDateTime.of(2022, 11, 2, 12, 30));
		assertEquals(0.0, dayDiscount.applyDiscount(showing));
	}

}
