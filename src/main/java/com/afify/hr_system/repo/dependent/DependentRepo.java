package com.afify.hr_system.repo.dependent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;

import jakarta.transaction.Transactional;

public interface DependentRepo extends JpaRepository<Dependent, DependentPrimaryKey>{
	
	@Transactional
	@Modifying
	@NativeQuery(value = "delete from dependent where essn=:ssn")
	public void deleteByEmpSsn(@Param("ssn") int ssn);
}
