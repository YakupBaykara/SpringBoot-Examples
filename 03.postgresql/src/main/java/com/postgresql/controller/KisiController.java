package com.postgresql.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.dto.KisiDto;
import com.postgresql.service.KisiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {
	
	private final KisiService kisiService;
	
	@PostMapping
	public ResponseEntity<KisiDto> ekle(@RequestBody KisiDto kisiDto) {
		return ResponseEntity.ok(kisiService.save(kisiDto));
	}
	
	@GetMapping
	public ResponseEntity<List<KisiDto>> tumunuListele() {
		return ResponseEntity.ok(kisiService.getAll());
	}

}
