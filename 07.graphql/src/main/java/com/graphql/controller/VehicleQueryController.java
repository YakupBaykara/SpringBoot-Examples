package com.graphql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.entity.Vehicle;
import com.graphql.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleQueryController implements GraphQLQueryResolver{

	private final VehicleRepository vehicleRepository;
	
	public List<Vehicle> getVehicles(String type) {
		return vehicleRepository.findByTypeLike(type);
	}
	
	public Optional<Vehicle> getById(Long id) {
		return vehicleRepository.findById(id);
		
	}
}
