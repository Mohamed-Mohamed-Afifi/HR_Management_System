package com.example.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.Dependent;
import com.example.main.repo.DependentRepo;

@Service
public class DependentService {
	@Autowired
	public DependentRepo dependentRepo;
	public List<Dependent> getAlldependent(){
		return dependentRepo.findAll();
	}
}
