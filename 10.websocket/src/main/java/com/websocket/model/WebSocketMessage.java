package com.websocket.model;

import lombok.Data;

@Data
public class WebSocketMessage {
	
	private String sender;
	private String message;

}
