package com.jpmc.theater.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;

public class TheaterServiceImplTests {
	
	@InjectMocks
	private TheaterServiceImpl theaterServiceImpl;
	
	@Mock
	private DiscountService discountService;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetShowingFeeForDiscountSmallerThanTicketPrice() {
		Mockito.when(discountService.getDiscount(ArgumentMatchers.any(Showing.class)))
			.thenReturn(1.0);
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(7.0);
		assertEquals(6.0, theaterServiceImpl.getShowingFee(showing));
	}
	
	@Test
	public void testGetShowingFeeForDiscountGreaterThanTicketPrice() {
		Mockito.when(discountService.getDiscount(ArgumentMatchers.any(Showing.class)))
			.thenReturn(4.0);
		Showing showing = Mocks.getMockShowing();
		showing.getMovie().setTicketPrice(2.0);
		assertEquals(0.0, theaterServiceImpl.getShowingFee(showing));
	}

}
