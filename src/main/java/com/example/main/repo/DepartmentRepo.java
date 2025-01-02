package com.example.main.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.main.modal.Departments;

@Repository
public interface DepartmentRepo extends ListCrudRepository<Departments, Integer>{
	
	public List<Departments> findByDepartmentName(String dname);
	@Modifying
	@Transactional
    @Query("insert into Departments(Dname, Dnum, MGRSSN, [MGRStart Date]) values(:Dname , :Dnum , :MGRSSN , :MGRStartDate)")
    public void addDepartment(@Param("Dnum") Integer Dnum, @Param("Dname") String Dname, @Param("MGRSSN") Integer MGRSSN, @Param("MGRStartDate") LocalDateTime MGRStartDate);
    
    
	

}
