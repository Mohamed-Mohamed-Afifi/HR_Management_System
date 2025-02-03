package com.afify.hr_system.model.projects;

import java.time.LocalDateTime;
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
    private Integer projectId;
	@NotBlank
    private String projectName;

    private String location;

    private String city;
    private Integer departmentNumber;
    private Set<EmpDTO> employees;
    private LocalDateTime created_at;
    private LocalDateTime lastModified;
private String created_by;
private String lastModified_by;
  
}
