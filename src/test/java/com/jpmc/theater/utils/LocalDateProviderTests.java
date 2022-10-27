package com.jpmc.theater.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
	
	@Test
	public void testSingletonInstance() {
		LocalDateProvider LocalDateProviderInstance1 = LocalDateProvider.INSTANCE;
		LocalDateProvider LocalDateProviderInstance2 = LocalDateProvider.INSTANCE;
		
		assertEquals(LocalDateProviderInstance1, LocalDateProviderInstance2);
	}

}
