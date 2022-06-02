package com.apidoc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apidoc.entity.Pet;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	List<Pet> petList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		petList.add(new Pet(1, "Yeni Pet", new Date()));
	}
	
	@PostMapping
	@ApiOperation(value = "Yeni pet ekleme metodu", notes = "Bu metodu dikkatli kullan")
	public /*@ApiResponse(s)*/ ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "hayvan") Pet pet) {
		petList.add(pet);
		return ResponseEntity.ok(pet);
	}
	
	@GetMapping
	@ApiOperation(value = "Yeni listeleme metodu", notes = "Bu metod tümünü getirir")
	public ResponseEntity<List<Pet>> getAll() {
		return ResponseEntity.ok(petList);
	}

}
