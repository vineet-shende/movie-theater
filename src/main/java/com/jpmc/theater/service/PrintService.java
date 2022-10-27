package com.jpmc.theater.service;

import java.util.List;

import com.jpmc.theater.model.Showing;

public interface PrintService {
	
	String printScheduleInTextFormat();
	
	List<Showing> printScheduleInJsonFormat();
}
