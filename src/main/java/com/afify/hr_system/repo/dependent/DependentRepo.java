package com.afify.hr_system.repo.dependent;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
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
	@NativeQuery(value = "delete from dependent where ESSN=:ssn")
//	@EntityGraph(attributePaths = {"dependentId.employee"}) 
	public void deleteByEmpSsn(@Param("ssn") int ssn);
	@EntityGraph(attributePaths = {"dependentId.employee"})
	public List<Dependent> findAll();
	@EntityGraph(attributePaths = {"dependentId.employee"})
	public List<Dependent> findByDependentIdEmployeeSsn(int id);
	@EntityGraph(attributePaths = {"dependentId.employee"})
	public Page<Dependent> findAll(Specification<Dependent> spec,Pageable page);
}
