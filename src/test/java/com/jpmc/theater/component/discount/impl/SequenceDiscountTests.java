package com.jpmc.theater.component.discount.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;

public class SequenceDiscountTests {
	
	@InjectMocks
	private SequenceDiscount sequenceDiscount;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApplyDiscountForShowingSequenceOne() {
		Showing showing = Mocks.getMockShowing();
		showing.setSequenceOfTheDay(1);
		assertEquals(3.0, sequenceDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForShowingSequenceTwo() {
		Showing showing = Mocks.getMockShowing();
		showing.setSequenceOfTheDay(2);
		assertEquals(2.0, sequenceDiscount.applyDiscount(showing));
	}
	
	@Test
	public void testApplyDiscountForShowingSequenceThree() {
		Showing showing = Mocks.getMockShowing();
		showing.setSequenceOfTheDay(3);
		assertEquals(0.0, sequenceDiscount.applyDiscount(showing));
	}

}
