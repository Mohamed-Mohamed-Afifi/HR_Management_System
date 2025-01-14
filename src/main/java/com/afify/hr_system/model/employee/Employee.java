package com.afify.hr_system.model.employee;

import java.time.LocalDateTime;
import java.util.List;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.dependent.Dependent;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
//	@OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Employee> sub_emp;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Superssn")
	private Employee manager;
	
	@OneToMany(mappedBy = "dependentId.employee",cascade = CascadeType.PERSIST)
	private List<Dependent> dependents;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonBackReference
	@JoinColumn(name="Dno")
	private Department department;


	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public LocalDateTime getBdate() {
		return bdate;
	}


	public void setBdate(LocalDateTime bdate) {
		this.bdate = bdate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Employee(int ssn, String fname, String lname, LocalDateTime bdate, String address, String sex, int salary,
			Employee manager, Department department) {
		super();
		this.ssn = ssn;
		this.fname = fname;
		this.lname = lname;
		this.bdate = bdate;
		this.address = address;
		this.sex = sex;
		this.salary = salary;
		this.manager = manager;
		this.department = department;
	}


	public Employee() {
		super();
	}
	
	
	
}
