package com.afify.hr_system.controller.dependent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;
import com.afify.hr_system.service.dependent.DependentService;
@RestController
@RequestMapping("/dependents")
public class DependentController {
	@Autowired
	private DependentService deService;
	
	@GetMapping("")
	public List<Dependent> getAll(){
		return deService.getAlldependents();
	}
	@PostMapping("")
	public List<Dependent> addEmp(@RequestBody Dependent dep){
		return deService.addDependent(dep);
	}
	@DeleteMapping("/{id}")
	public List<Dependent> deleteEmp(@PathVariable DependentPrimaryKey id){
		return deService.deleteById(id);
	}
	@PutMapping("")
	public List<Dependent> udpateEmp(@RequestBody Dependent dep){
		return deService.update(dep);
	}
}

