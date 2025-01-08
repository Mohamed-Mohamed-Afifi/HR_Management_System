package com.example.main.repo.car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.car.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {
	
}
