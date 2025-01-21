package com.afify.hr_system.repo.employee.dao;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchArgs {
	
	private String name;
	private Integer ssn;
	private String full_name;
	private LocalDateTime birthdate;
	private String address;
	private String sex;
	private Integer salary;	
	private Integer manager_ssn;
	private Integer department_number;
	private String departmentName;
	
}
