package com.example.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.Car;
import com.example.main.repo.CarRepo;

@Service
public class CarService {
	
	@Autowired
	private CarRepo carRepo;
	public List<Car> getAllCars() {
		return carRepo.findAll();
	}

	public Car getCarById(Integer id) {
		if (carRepo.existsById(id)) {
			return carRepo.findById(id).get();
		} else {
			return new Car();
		}
	}
	
	public List<Car> addCar(Car car) {
		 carRepo.save(car);
		 return carRepo.findAll();
	}
	
	public List<Car> updateCar(Car car) {
		Car currentCar=carRepo.findById(car.getCarId()).get();
		currentCar.setCarName(car.getCarName());
		currentCar.setEmpId(car.getEmpId());
		carRepo.save(currentCar);
		return carRepo.findAll();
	}

}
