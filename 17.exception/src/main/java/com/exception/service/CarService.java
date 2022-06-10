package com.exception.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.exception.dto.Car;
import com.exception.exc.EntityNotFoundException;

@Service
public class CarService {
	
	private static List<Car> carList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		carList.add(new Car("Car A", "Brand 1"));
		carList.add(new Car("Car B", "Brand 2"));
		carList.add(new Car("Car C", "Brand 3"));
	}

	public Car getCar(String name) {
		
		if(name.startsWith("1"))
			throw new IllegalArgumentException();
		
		return carList.stream().filter(x -> x.getName().equals(name)).findFirst()
					  .orElseThrow(() -> new EntityNotFoundException(name));
	}

}
