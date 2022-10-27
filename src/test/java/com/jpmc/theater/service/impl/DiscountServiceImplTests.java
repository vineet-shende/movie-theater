package com.jpmc.theater.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jpmc.theater.component.discount.Discount;
import com.jpmc.theater.component.discount.impl.DayDiscount;
import com.jpmc.theater.component.discount.impl.SequenceDiscount;
import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Showing;

public class DiscountServiceImplTests {
	
	@InjectMocks
	private DiscountServiceImpl discountServiceImpl;
	
	@Mock
	private List<Discount> discountList;
	
	@Mock
	private DayDiscount dayDiscount;
	
	@Mock
	private SequenceDiscount sequenceDiscount;
	
	private Iterator<Discount> discountIterator;
	
	@BeforeEach
	void init(){
	    MockitoAnnotations.initMocks(this);
	    discountIterator = Mockito.mock(Iterator.class);
	    Mockito.when(discountList.iterator()).thenReturn(discountIterator);
	    Mockito.when(discountIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
	    Mockito.when(discountIterator.next())
	    .thenReturn(dayDiscount)
	    .thenReturn(sequenceDiscount);
	}
	
	@Test
	public void testGetDiscountWithDiscountsConfigured() {
		Mockito.when(dayDiscount.applyDiscount(ArgumentMatchers.any(Showing.class)))
			.thenReturn(2.0);
		Mockito.when(sequenceDiscount.applyDiscount(ArgumentMatchers.any(Showing.class)))
			.thenReturn(3.0);
		Showing showing = Mocks.getMockShowing();
		assertEquals(3.0, discountServiceImpl.getDiscount(showing));
	}
	
	@Test
	public void testGetDiscountWithoutDiscountsConfigured() {
		Mockito.when(discountIterator.hasNext()).thenReturn(false);
		Showing showing = Mocks.getMockShowing();
		assertEquals(0.0, discountServiceImpl.getDiscount(showing));
	}
	
}
