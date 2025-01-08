package com.example.main.services.dependent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.dependent.Dependent;
import com.example.main.repo.dependent.DependentRepo;

@Service
public class DependentService {
	@Autowired
	public DependentRepo dependentRepo;
	public List<Dependent> getAlldependent(){
		return dependentRepo.findAll();
	}
}
