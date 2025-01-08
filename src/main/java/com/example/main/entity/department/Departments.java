package com.example.main.entity.department;

import java.time.LocalDateTime;
import java.util.List;

import com.example.main.entity.employee.Employee;
import com.example.main.entity.project.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="Departments")
@Entity
public class Departments {
	@Id
	@Column(name="Dnum")
	@JsonProperty("departmentNumber")
	private Integer departmentNumber;
	@Column(name="Dname")
	@JsonProperty("departmentName")
	private String departmentName;
	@Column(name="MGRStart Date")
	@JsonProperty("managerStartDate")
	private LocalDateTime managerStartDate;

	@ManyToOne
	@JoinColumn(name="MGRSSN" ,referencedColumnName = " SSN ")
	private Employee managerOfDept;
	
	@OneToMany(mappedBy="department")
	@JsonManagedReference
	private List<Project> project;
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	@JsonManagedReference
	private List<Employee> employee;
	
	public Employee getManagerOfDept() {
		return managerOfDept;
	}



	public void setManagerOfDept(Employee managerOfDept) {
		this.managerOfDept = managerOfDept;
	}



	public List<Employee> getEmployee() {
		return employee;
	}



	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}



	public List<Project> getProject() {
		return project;
	}



	public void setProject(List<Project> project) {
		this.project = project;
	}



	public Departments() {
		super();
	}

	
	
	public Departments(Integer departmentNumber, String departmentName, LocalDateTime managerStartDate) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
//		this.managerSSN = managerSSN;
		this.managerStartDate = managerStartDate;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public LocalDateTime getManagerStartDate() {
		return managerStartDate;
	}

	public void setManagerStartDate(LocalDateTime managerStartDate) {
		this.managerStartDate = managerStartDate;
	}


}
