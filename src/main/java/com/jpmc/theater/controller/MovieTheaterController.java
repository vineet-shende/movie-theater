package com.jpmc.theater.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.PrintService;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.TheaterService;

@RestController
@RequestMapping("/movie-theater")
public class MovieTheaterController {
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private PrintService printService;
	
	@Autowired
	private ReservationService reservationService;
	
	/**
	 * Method for printing schedule in text format.
	 * @return ResponseEntity<String>
	 */
	@GetMapping(value = "/printSchedule/text")
    public ResponseEntity<String> printScheduleInTextFormat() {
		System.out.println("Received request to print schedule in text format");
        return new ResponseEntity<>(printService.printScheduleInTextFormat(), HttpStatus.OK);
    }
	
	/**
	 * Method for printing schedule in json format.
	 * @return ResponseEntity<List<Showing>>
	 */
	@GetMapping(value = "/printSchedule/json")
    public ResponseEntity<List<Showing>> printScheduleInJsonFormat() {
		System.out.println("Received request to print schedule in json format");
        return new ResponseEntity<>(printService.printScheduleInJsonFormat(), HttpStatus.OK);
    }
	
	/**
	 * Method for getting movie showing fee.
	 * @param showing Showing
	 * @return ResponseEntity<Double>
	 */
	@GetMapping(value = "/showingFee")
    public ResponseEntity<Double> getShowingFee(@RequestBody Showing showing) {
		System.out.println("Received request to get showing fee");
        return new ResponseEntity<>(theaterService.getShowingFee(showing), HttpStatus.OK);
    }
	
	/**
	 * Method to get total showing fee based on audience count.
	 * @param audienceCount Integer
	 * @param showing Showing
	 * @return ResponseEntity<Double>
	 */
	@GetMapping(value = "/totalShowingFee/{audienceCount}")
    public ResponseEntity<Double> getTotalShowingFee(
    		@PathVariable(name = "audienceCount") Integer audienceCount, 
    		@RequestBody Showing showing) {
		System.out.println("Received request to get total showing fee");
        return new ResponseEntity<>(
        		theaterService.getShowingFee(showing) * audienceCount, HttpStatus.OK);
    }
	
	/**
	 * Method to reserve a showing.
	 * @param reservation Reservation
	 * @return ResponseEntity<UUID>
	 */
	@PostMapping(value = "/reserveShowing")
	public ResponseEntity<UUID> reserve(@RequestBody Reservation reservation) {
		System.out.println("Received request to reserve the showing");
        return new ResponseEntity<>(reservationService.reserve(reservation), HttpStatus.CREATED);
    }
}
