package com.afify.hr_system.model.department;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.Formula;

import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.model.projects.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	@Id
	@Column(name="Dnum")
	private int departmentNumber;
	
	@Column(name="Dname")
	private String dname;
	
	@Column(name="MGRStart Date")
	private LocalDateTime mgsStartDate;
	@Formula(value = "(select count(*) from employee emp where emp.dno = dnum)")
	private int numOfEmp;
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="MGRSSN")
	private Employee supervisor;
	
	@OneToMany(mappedBy = "department")
	@JsonIgnore
	private Set<Employee> employees;
	
	
	@OneToMany(mappedBy = "department")
	@JsonIgnore
	private Set<Project> projects;

//	public int getDepartmentNumber() {
//		return departmentNumber;
//	}
//
//	public void setDepartmentNumber(int departmentNumber) {
//		this.departmentNumber = departmentNumber;
//	}
//
//	public String getDname() {
//		return dname;
//	}
//
//	public void setDname(String dname) {
//		this.dname = dname;
//	}
//
//	public LocalDateTime getMgsStartDate() {
//		return mgsStartDate;
//	}
//
//	public void setMgsStartDate(LocalDateTime mgsStartDate) {
//		this.mgsStartDate = mgsStartDate;
//	}
//
//	public Employee getSupervisor() {
//		return supervisor;
//	}
//
//	public void setSupervisor(Employee supervisor) {
//		this.supervisor = supervisor;
//	}
//
//	public Set<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(Set<Project> projects) {
//		this.projects = projects;
//	}
//	
//
//	public int getNumOfEmp() {
//		return numOfEmp;
//	}
//
//	public void setNumOfEmp(int numOfEmp) {
//		this.numOfEmp = numOfEmp;
//	}
//
//	public Set<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(Set<Employee> employees) {
//		this.employees = employees;
//	}
//
//	public Department(int departmentNumber, String dname, LocalDateTime mgsStartDate, Employee supervisor,
//			Set<Project> projects) {
//		super();
//		this.departmentNumber = departmentNumber;
//		this.dname = dname;
//		this.mgsStartDate = mgsStartDate;
//		this.supervisor = supervisor;
//		this.projects = projects;
//	}
//
//	public Department() {
//		super();
//	}
	
}
