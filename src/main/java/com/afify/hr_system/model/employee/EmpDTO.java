package com.afify.hr_system.model.employee;

import java.time.LocalDateTime;
import java.util.List;

import com.afify.hr_system.model.dependent.DependentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {

	private int ssn;
	private String first_name;
	private String last_name;
	private LocalDateTime birthdate;
	private String address;
	private String sex;
	private int salary;	
	private Integer manager_ssn;
	private Integer department_number;
	private List<DependentDto>dependents;
}
