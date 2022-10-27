package com.jpmc.theater.service;

import java.util.UUID;

import com.jpmc.theater.model.Reservation;

public interface ReservationService {
	
	UUID reserve(Reservation reservation);
}
