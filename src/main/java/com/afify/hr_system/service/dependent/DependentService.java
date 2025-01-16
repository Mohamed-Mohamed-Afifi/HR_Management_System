package com.afify.hr_system.service.dependent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<?> addDependent(Dependent dept){
		dependentRepo.save(dept);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> update(Dependent dept){
		dependentRepo.save(dept);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> deleteById(DependentPrimaryKey id){
		dependentRepo.deleteById(id);
		return ResponseEntity.ok(null);
	} 
}
