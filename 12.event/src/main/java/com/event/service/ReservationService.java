package com.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.event.controller.BookingController.HotelBookRequest;
import com.event.event.ReservationCreatedEvent;

@Service
public class ReservationService {
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Async
	public void publishReservationEvent(HotelBookRequest hotelBookRequest) {
		applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
	}
}
