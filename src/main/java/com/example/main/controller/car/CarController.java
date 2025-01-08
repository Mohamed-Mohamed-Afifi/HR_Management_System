package com.example.main.controller.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.car.Car;
import com.example.main.services.car.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("")
	public List<Car> addCar(@RequestBody Car car) {
		return carService.addCar(car);	}
	
	@GetMapping("")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	@PutMapping("")
	public List<Car> updateCar(@RequestBody Car car) {
		return carService.updateCar(car);
	}
	
	
	
}
