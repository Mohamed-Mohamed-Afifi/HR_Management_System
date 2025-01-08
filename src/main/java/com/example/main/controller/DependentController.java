package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.Dependent;
import com.example.main.services.DependentService;

@RestController
@RequestMapping("/dependents")
public class DependentController {
	@Autowired
	public DependentService dependentService;
	@GetMapping("")
	public List<Dependent> getAllDependent(){
		return dependentService.getAlldependent();
	}
}
