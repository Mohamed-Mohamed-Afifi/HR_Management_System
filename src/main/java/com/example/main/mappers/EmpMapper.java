package com.example.main.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//import javax.swing.tree.RowMapper;

import com.example.main.modal.Employee;

public class EmpMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(
				rs.getInt("SSN"),
 	            rs.getString("Fname"),
 	            rs.getString("Lname"),
 	            rs.getDate("Bdate").toString(),
 	            rs.getString("Address"),
 	            rs.getString("Sex"),
 	            rs.getObject("Superssn", Integer.class),
 	            rs.getInt("Salary"),
 	            rs.getInt("Dno")
 	                );
	}

}
