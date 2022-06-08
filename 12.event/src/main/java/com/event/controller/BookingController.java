package com.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.service.ReservationService;

import lombok.Data;

@RestController
@RequestMapping("/book")
public class BookingController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest) {
		reservationService.publishReservationEvent(hotelBookRequest);
		System.out.println("Kullanıcı isteği işleme alındı :" +hotelBookRequest);		
	}
		
	@Data
	public static class HotelBookRequest {
		private String userId;
		private String hotelId;
	}
}
