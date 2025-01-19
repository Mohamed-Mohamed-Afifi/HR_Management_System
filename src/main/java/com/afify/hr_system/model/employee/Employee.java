package com.afify.hr_system.model.employee;

import java.time.LocalDateTime;
import java.util.Set;

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



	@PostLoad
	public void setPouns() {
		this.pouns = this.salary*10;
	}

	
	
}
