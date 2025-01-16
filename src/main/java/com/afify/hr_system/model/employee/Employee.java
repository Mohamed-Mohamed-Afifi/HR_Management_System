package com.afify.hr_system.model.employee;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.dependent.Dependent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@Column(name="SSN")
	private int ssn;
	@Column(name ="Fname")
	private String fname;
	@Column(name ="Lname")
	private String lname;
	@Column(name="Bdate")
	private LocalDateTime bdate;
	@Column(name="address")
	private String address;
	@Column(name="Sex")
	private String sex;
	@Column(name="Salary")
	private int salary;	
	@Transient
	private int pouns;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="Superssn")
	private Employee manager;
	
	@OneToMany(mappedBy = "dependentId.employee",cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<Dependent> dependents;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="Dno")
	private Department department;


//	public int getSsn() {
//		return ssn;
//	}
//
//
//	public void setSsn(int ssn) {
//		this.ssn = ssn;
//	}
//
//
//	public String getFname() {
//		return fname;
//	}
//
//
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
//
//
//	public String getLname() {
//		return lname;
//	}
//
//
//	public void setLname(String lname) {
//		this.lname = lname;
//	}
//
//
//	public LocalDateTime getBdate() {
//		return bdate;
//	}
//
//
//	public void setBdate(LocalDateTime bdate) {
//		this.bdate = bdate;
//	}
//
//
//	public String getAddress() {
//		return address;
//	}
//
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//
//	public String getSex() {
//		return sex;
//	}
//
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//
//	public int getSalary() {
//		return salary;
//	}
//
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//
//	public Employee getManager() {
//		return manager;
//	}
//
//
//	public void setManager(Employee manager) {
//		this.manager = manager;
//	}
//
//
//	public Department getDepartment() {
//		return department;
//	}
//
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
//
//
//	public int getPouns() {
//		return pouns;
//	}
//
//
	@PostLoad
	public void setPouns() {
		this.pouns = this.salary*10;
	}
//
//
//	public Set<Dependent> getDependents() {
//		return dependents;
//	}
//
//
//	public void setDependents(Set<Dependent> dependents) {
//		this.dependents = dependents;
//	}
//
//
//	public Employee(int ssn, String fname, String lname, LocalDateTime bdate, String address, String sex, int salary,
//			Employee manager, Department department) {
//		super();
//		this.ssn = ssn;
//		this.fname = fname;
//		this.lname = lname;
//		this.bdate = bdate;
//		this.address = address;
//		this.sex = sex;
//		this.salary = salary;
//		this.manager = manager;
//		this.department = department;
//	}
//
//
//	public Employee() {
//		super();
//	}
	
	
	
}
