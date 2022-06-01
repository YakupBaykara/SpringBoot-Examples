package com.elasticsearch.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.entity.Kisi;
import com.elasticsearch.repository.KisiRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {
	
	private final KisiRepository kisiRepository;
	
	@PostConstruct
	public void init() {
		Kisi kisi = new Kisi();
		kisi.setId("K00001");
		kisi.setAd("Yakup");
		kisi.setSoyad("BAYKARA");
		kisi.setAdres("---------");
		kisi.setDogumTarihi(Calendar.getInstance().getTime());
		kisiRepository.save(kisi);
	}
	
	@GetMapping("/{search}")
	public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
		List<Kisi> kisiler = kisiRepository.findByAdLikeAndSoyadLike(search, search);		
		return ResponseEntity.ok(kisiler);
	}
}
