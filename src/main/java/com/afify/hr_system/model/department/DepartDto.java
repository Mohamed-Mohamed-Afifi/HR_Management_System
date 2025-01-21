package com.afify.hr_system.model.department;

import java.time.LocalDateTime;
import java.util.List;

import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.projects.ProjectDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartDto {
	@NotNull
	private int dnum;
	@NotBlank
	private String dname;
	@NotNull
	private LocalDateTime mgsStartDate;
	private String supervisorName;
	private Integer supervisorSsn;
	private int numOfEmp;
	private List<EmpDTO> employees;
	private List<ProjectDto> projects;
}
