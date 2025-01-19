package com.afify.hr_system.service.dependent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.dependent.DependentMapper;
import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentDto;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;
import com.afify.hr_system.repo.dependent.DependentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DependentService {
	private final DependentRepo dependentRepo;
	private final DependentMapper depnMapper;
	
	public List<DependentDto> getAlldependents(){
		List<Dependent> dependents=dependentRepo.findAll();
		List<DependentDto> dependentsDto=dependents.stream().map(depnMapper::map).collect(Collectors.toList());
		return dependentsDto;
	}
	
	public ResponseEntity<?> addDependent(DependentDto depntDto){
		System.out.println(depntDto);
		Dependent dependent=depnMapper.unmap(depntDto);
		dependentRepo.save(dependent);
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
