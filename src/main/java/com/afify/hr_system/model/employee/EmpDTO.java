package com.afify.hr_system.model.employee;

import java.time.LocalDateTime;
import java.util.List;

import com.afify.hr_system.model.dependent.DependentDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	@NotNull
	private int ssn;
	@NotBlank
	private String full_name;
	@NotNull
	private LocalDateTime birthdate;
	@NotBlank
	private String address;
	@NotBlank
	private String sex;
	@Min(value = 500)
	@Max(value=500000)
	private int salary;	
	private Integer manager_ssn;
	private Integer department_number;
//	private List<DependentDto>dependents;
}
