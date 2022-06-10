package com.exception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.dto.Car;
import com.exception.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;

	@GetMapping
	public ResponseEntity<Car> getCar(@RequestParam String name) {
//		return ResponseEntity.of(Optional.of(carService.getCar(name)));
		return ResponseEntity.ok(carService.getCar(name));
	}

/*	
 	// This method will run when an exception occur in this endpoint.
	@ExceptionHandler({EntityNotFoundException.class})
	public String entityNotFound() {
		return "No record found!";
	}
*/
}
