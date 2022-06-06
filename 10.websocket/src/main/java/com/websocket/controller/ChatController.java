package com.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.websocket.model.WebSocketMessage;

@Controller
@CrossOrigin
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/chat")
//	@SendTo("/topic")
//	@SendToUser()
	public void chatEndPoint (@Payload WebSocketMessage webSocketMessage) {
		System.out.println(webSocketMessage);
		messagingTemplate.convertAndSend("/topic", webSocketMessage);
	}
}
