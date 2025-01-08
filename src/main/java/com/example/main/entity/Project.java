package com.example.main.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Project")
public class Project{
		
	@Id
	@Column(name="Pnumber")
	private Integer projectNumber;
	@Column(name="Pname")
	private String projectName;
	@Column(name="Plocation")
	private String projectLocation;
	@Column(name="City")
	private String city;
	@ManyToOne
	@JoinColumn(name="Dnum")
	@JsonBackReference
	private Departments department;

	public Integer getProjectNumber() {
		return projectNumber;
	}
	
	
	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public Departments getDepartment() {
//		return department;
//	}
//	public void setDepartment(Departments department) {
//		this.department = department;
//	}
	public Project(Integer projectNumber, String projectName, String projectLocation, String city) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.projectLocation = projectLocation;
		this.city = city;
	}
	public Project() {
		super();
	}
//	public Integer getDepartmentNumber() {
//		return departmentNumber;
//	}
//
//	public void setDepartmentNumber(Integer departmentNumber) {
//		this.departmentNumber = departmentNumber;
//	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	
}

