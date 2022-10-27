package com.jpmc.theater.mock;

import java.time.LocalDateTime;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

public class Mocks {
	
	public static Showing getMockShowing() {
		Movie movie = new Movie("Spider-Man: No Way Home", "Spider Man Movie", 90, 12.5, 1);
		return new Showing(movie, 1, LocalDateTime.of(2022, 11, 1, 12, 30));
	}

}
