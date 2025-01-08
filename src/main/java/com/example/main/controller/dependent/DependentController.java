package com.example.main.controller.dependent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.dependent.Dependent;
import com.example.main.services.dependent.DependentService;

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
