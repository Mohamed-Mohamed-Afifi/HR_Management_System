package com.example.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.main.entity.Departments;
import com.example.main.entity.Employee;
import com.example.main.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;
	
	public int getDeptCount() {
		return (int) deptRepo.count();
	}
	
	public List<Departments> getAllDepartments() {
		return deptRepo.findAll();
	}
	
	public Departments getDepartmentById(Integer id) {
		if(deptRepo.existsById(id)) {
			return deptRepo.findById(id).get();			
		} else {
			return null;
		}
	}
	
	public List<Departments> getDepartmentByName(String dname) {
		return deptRepo.findByDepartmentName(dname);
	}

	public ResponseEntity<List<Departments>> addDepartment(Departments dept, String auth) {
		try {
			List<Departments> departments ;
			if(deptRepo.existsById(dept.getDepartmentNumber())) {
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
			} else {
//				deptRepo.addDepartment(dept.getDepartmentName(), dept.getDepartmentNumber(),dept.getManagerSSN(), dept.getManagerStartDate());
//				for(Employee emp:dept.getEmployee()) {
//					
//				}
				deptRepo.save(dept);
				departments=deptRepo.findAll();
				return new ResponseEntity<>(departments, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}
	
	public List<Departments> updateDepartment(Departments dept) {
		if (deptRepo.existsById(dept.getDepartmentNumber())) {
			deptRepo.save(dept);
		} else {
			return null;
		}
		return deptRepo.findAll();
	}
	
	public List<Departments> deleteDepartment(Integer id) {
		deptRepo.deleteById(id);
		return deptRepo.findAll();
	}
	
	public  List<Departments> findDepartmentsManagedBySsn(int ssn){
		return deptRepo.findByManagerOfDeptSsn(ssn);
	}
	
}
