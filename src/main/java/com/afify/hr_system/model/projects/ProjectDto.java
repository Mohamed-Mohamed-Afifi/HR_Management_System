package com.afify.hr_system.model.projects;

import java.util.Set;

import com.afify.hr_system.model.employee.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private int projectId;
    private String projectName;
    private String location;
    private String city;
    private Integer departmentNumber;
    private Set<EmpDTO> employees;
  
}
