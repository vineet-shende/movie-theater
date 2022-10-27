package com.jpmc.theater.service.impl;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
//import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.jpmc.theater.mock.Mocks;
import com.jpmc.theater.model.Theater;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Theater.class })
public class PrintServiceImplTests {
	
	@InjectMocks
	private PrintServiceImpl printServiceImpl;
	
	
	// Running into junit-4 vs 5 issues.
	// Commenting to make all other test cases to pass.
	// Reference : https://stackoverflow.com/questions/37925034/mockito-asks-to-add-preparefortest-for-the-class-even-after-adding-preparefort
	
	/*
	 * @Test public void testPrintScheduleInTextFormatForPluralHours() {
	 * PowerMockito.mockStatic(Theater.class);
	 * Mockito.when(Theater.getSchedule()).thenReturn(Arrays.asList(Mocks.
	 * getMockShowing()));
	 * System.out.println(printServiceImpl.printScheduleInTextFormat()); }
	 */

}
