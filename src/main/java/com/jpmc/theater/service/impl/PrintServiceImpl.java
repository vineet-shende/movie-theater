package com.jpmc.theater.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.service.PrintService;
import com.jpmc.theater.utils.LocalDateProvider;

@Service
public class PrintServiceImpl implements PrintService {

	/**
	 * Method to print schedule in json format.
	 * @return List<Showing>
	 */
	@Override
	public List<Showing> printScheduleInJsonFormat() {
		System.out.println("Returning schedule in json format");
		return Theater.getSchedule();
	}

	/**
	 * Method to print schedule in text format.
	 * @return String
	 */
	@Override
	public String printScheduleInTextFormat() {
		System.out.println("Staring to print schedule in text format");
		StringBuilder textFormatSchedule = new StringBuilder(
				LocalDateProvider.INSTANCE.currentDate().toString());
		
		textFormatSchedule.append("=========================================");
		
		List<Showing> schedule = Theater.getSchedule();
        schedule.forEach(showing -> 
        	textFormatSchedule.append(showing.getSequenceOfTheDay() + ": " 
        		+ showing.getShowStartTime() + ", " + showing.getMovie().getTitle() + ", " 
        		+ getDurationInHrsAndMins(showing.getMovie().getDurationInMins()) 
        		+ ", $" + showing.getMovie().getTicketPrice())
        );
        
        textFormatSchedule.append("=========================================");
        
        System.out.println("Returning schedule in text format");
        
        return textFormatSchedule.toString();
	}
	
	/**
	 * Method to get duration in hours and mins.
	 * @param durationInMins Integer
	 * @return String
	 */
	private String getDurationInHrsAndMins(Integer durationInMins) {
		System.out.println("Received durationInMins value: " + durationInMins);
		Duration duration = Duration.ofMinutes(durationInMins);
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(hour);

        return String.format("%s hour%s %s minute%s", hour, handlePlural(hour), 
        		remainingMin, handlePlural(remainingMin));
    }
    
	/**
	 * Method to apply postfix (s) to handle plural correctly.
	 * @param value long
	 * @return String
	 */
    private String handlePlural(long value) {
    	System.out.println("Received value: " + value);
    	String returnValue = "s";
        if (value == 1) {
        	returnValue = "";
        }
        
        return returnValue;
    }

}
