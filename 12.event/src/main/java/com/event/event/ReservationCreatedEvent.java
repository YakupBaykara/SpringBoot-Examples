package com.event.event;

import org.springframework.context.ApplicationEvent;

public class ReservationCreatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public ReservationCreatedEvent(Object source) {
		super(source);
	}

}
