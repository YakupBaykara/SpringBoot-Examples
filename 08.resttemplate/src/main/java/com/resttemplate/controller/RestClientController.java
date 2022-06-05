package com.resttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.model.KisiDto;


@RestController
@RequestMapping("/test")
public class RestClientController {
	
	private static final String WEB_URL = "http://localhost:8081/kisi";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<List<KisiDto>> findAll() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> result = restTemplate.getForEntity(WEB_URL, List.class);
		@SuppressWarnings("unchecked")
		List<KisiDto> responseBody = result.getBody();
		return ResponseEntity.ok(responseBody);
	}
	
	@PostMapping
	public ResponseEntity<KisiDto> save(@RequestBody KisiDto kisiDto) {
		ResponseEntity<KisiDto> result = restTemplate.postForEntity(WEB_URL, kisiDto, KisiDto.class);
		KisiDto responseBody = result.getBody();
		return ResponseEntity.ok(responseBody);
	}

}
