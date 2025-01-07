package com.example.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {
	
}
