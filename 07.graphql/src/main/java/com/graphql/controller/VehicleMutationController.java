package com.graphql.controller;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.dto.VehicleDto;
import com.graphql.entity.Vehicle;
import com.graphql.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleMutationController implements GraphQLMutationResolver{

	private final VehicleRepository vehicleRepository;
	
	public Vehicle saveVehicle(VehicleDto vehicleDto) {
		return vehicleRepository.save(dtoToEntity(vehicleDto));
	}
	
	private Vehicle dtoToEntity(VehicleDto vehicleDto) {
		Vehicle vehicle = new Vehicle();
		vehicle.setBrandName(vehicleDto.getBrandName());
		vehicle.setModelCode(vehicleDto.getModelCode());
		vehicle.setType(vehicleDto.getType());
		vehicle.setLaunchDate(new Date());
		return vehicle;
	}
}
