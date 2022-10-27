package com.jpmc.theater.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	/**
	 * Method to reserve a showing.
	 * @param reservation Reservation
	 * @return UUID
	 */
	@Override
	public UUID reserve(Reservation reservation) {
		/* We can persist the reservation in db and provide the relevant details 
		 * with id in the response. For simplicity, returning just the random UUID.
		 */
		System.out.println("Returning id of reservation");
		
		return UUID.randomUUID();
	}

}
