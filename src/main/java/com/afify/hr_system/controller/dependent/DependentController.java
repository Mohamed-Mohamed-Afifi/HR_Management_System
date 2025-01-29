package com.afify.hr_system.controller.dependent;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.model.dependent.DependentDto;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;
import com.afify.hr_system.repo.dependent.search.PageSearchSpec;
import com.afify.hr_system.service.dependent.DependentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/dependents")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class DependentController {
	private final DependentService deService;
	
	@GetMapping("")
	public ResponseEntity<?> getAll(@RequestParam int pageNum,@RequestParam int pageSize){
		return ResponseEntity.ok(deService.getAlldependents(pageNum,pageSize));
	}
	@PostMapping("")
	public ResponseEntity<?> addEmp(@RequestBody @Valid DependentDto dep){
		return deService.addDependent(dep);
	}
	@DeleteMapping("")
	public ResponseEntity<?>  deleteEmp(@RequestBody @NotNull DependentPrimaryKey id){
		return deService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?>  udpateEmp(@RequestBody @Valid DependentDto dep){
		return deService.update(dep);
	}
	@PostMapping("/search")
	public ResponseEntity<?> filter(@RequestBody PageSearchSpec pageSpec){
		return ResponseEntity.ok(deService.filter(pageSpec));
	}
}

