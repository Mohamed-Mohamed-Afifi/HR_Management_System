package com.example.main.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.main.mappers.EmpMapper;
import com.example.main.modal.Employee;

@Repository
public class EmployeeRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
//	Return the count of employees
	public Integer getEmployeeCount() {
		return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
//		return 5;
	}

	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM employee WHERE SSN = :SSN";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("SSN", id);
	    List<Employee> employees = namedParameterJdbcTemplate.query(sql, params , new EmpMapper());

	    if (employees.isEmpty()) {
	        System.out.println("No employee found with SSN: " + id);
	        return null; // Or handle this case differently
	    }

	    return employees.get(0);
	}

	public List<Employee> getEmployees() {
		String sql = "SELECT * FROM employee";
         List<Employee> allEmployess=jdbcTemplate.query(sql,new EmpMapper());
         return allEmployess;
	}

	public void addEmployee(Employee emp) {
		  String sql = "INSERT INTO Employee (Fname, Lname, SSN, Bdate, Address, Sex, Salary, Superssn, Dno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		     jdbcTemplate.update(sql, emp.getFname(), emp.getLname(), emp.getSSN(), emp.getBdate(), emp.getAddress(), emp.getSex(), emp.getSalary(), emp.getSuperssn(), emp.getDno());
	}
	
	public void updateEmployee(Employee emp) {
        String sql = "UPDATE Employee SET Fname = ?, Lname = ?, Bdate = ?, Address =? , Sex = ?, Salary = ?, Superssn = ?, Dno = ? WHERE SSN = ?";
        jdbcTemplate.update(sql, emp.getFname(), emp.getLname(), emp.getBdate(), emp.getAddress(), emp.getSex(), emp.getSalary(), emp.getSuperssn(), emp.getDno(), emp.getSSN());
        
	}
	public void deleteEmployee(int id) {
		String sql = "DELETE FROM Employee WHERE SSN = ?";
		jdbcTemplate.update(sql, id);
	}
}