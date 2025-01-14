package com.afify.hr_system.repo.project_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;

import com.afify.hr_system.model.project_Emp.PrjEmp;
import com.afify.hr_system.model.project_Emp.PrjEmpKey;

import jakarta.transaction.Transactional;

public interface PrjEmpRepo extends JpaRepository<PrjEmp, PrjEmpKey>{
	@Transactional
	@Modifying
	@NativeQuery(value="delete from project_employees where essn=:ssn")
	public void deleteByEmpSsn(int ssn);
	@Transactional
	@Modifying
	@NativeQuery(value="delete from project_employees where pno=:ssn")
	public void deleteByProjectNum(int pno);
}
