package com.afify.hr_system.model.projects;

import java.util.Set;

import com.afify.hr_system.model.employee.EmpDTO;

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
public class ProjectDto {
	@NotNull
    private int projectId;
	@NotBlank
    private String projectName;
	@NotBlank
    private String location;
	@NotBlank
    private String city;
    private Integer departmentNumber;
    private Set<EmpDTO> employees;
  
}
