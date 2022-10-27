package com.jpmc.theater.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.theater.utils.LocalDateProvider;

public class Theater {
	
	private Theater() {}
	
	private static List<Showing> schedule;
	private static LocalDateProvider localDateProvider;
	
	// Ideally, this should come from Database layer.
	// For simplicity, created static block here to load schedule list once.
	static {
		localDateProvider = LocalDateProvider.INSTANCE;
		Movie spiderMan = new Movie("Spider-Man: No Way Home", "Spider Man Movie", 90, 12.5, 1);
        Movie turningRed = new Movie("Turning Red", "Turning Red Movie", 85, 11.0, 0);
        Movie theBatMan = new Movie("The Batman", "I am Batman", 95, 9.0, 0);
        schedule = List.of(
        	new Showing(turningRed, 1, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(23, 0)))
        );
	}
	
	// returning a clone of schedule so that caller is not able to modify the original one.
	public static List<Showing> getSchedule() {
		return new ArrayList<>(schedule);
	}
}
