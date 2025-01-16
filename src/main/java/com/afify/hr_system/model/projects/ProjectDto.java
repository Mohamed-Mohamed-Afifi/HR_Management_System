package com.afify.hr_system.model.projects;

import java.util.Set;

import com.afify.hr_system.model.employee.Employee;

public class ProjectDto {
    private int projectId;
    private String projectName;
    private Set<Employee> employees;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public ProjectDto(int projectId, String projectName, Set<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employees = employees;
	}
	public ProjectDto() {
		super();
	}
    
    
}
