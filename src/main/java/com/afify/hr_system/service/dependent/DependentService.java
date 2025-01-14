package com.afify.hr_system.service.dependent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;
import com.afify.hr_system.repo.dependent.DependentRepo;

@Service
public class DependentService {
	@Autowired
	private DependentRepo dependentRepo;
	
	public List<Dependent> getAlldependents(){
		return dependentRepo.findAll();
	}
	
	public List<Dependent> addDependent(Dependent dept){
		dependentRepo.save(dept);
		return dependentRepo.findAll();
	} 
	
	public List<Dependent> update(Dependent dept){
		dependentRepo.save(dept);
		return dependentRepo.findAll();
	} 
	
	public List<Dependent> deleteById(DependentPrimaryKey id){
		dependentRepo.deleteById(id);
		return dependentRepo.findAll();
	} 
}
