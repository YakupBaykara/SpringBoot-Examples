package com.dockerization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

	@GetMapping
	public String getMessage() {
		return "Hello from inside of Docker Image!";
	}
}
