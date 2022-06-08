package com.event.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReseravationEventListener {

	@EventListener
	public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Eventlistener -> " + reservationCreatedEvent.getSource().toString());
	}
}