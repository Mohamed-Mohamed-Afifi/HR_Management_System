package com.example.main.entity.dependent;

import java.time.LocalDateTime;

import com.example.main.entity.employee.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Dependent")
public class Dependent {

	@EmbeddedId
	private DependentPrimaryKey dependentKey;
		
	@Column(name="Sex")
	private String sex;
	
	@Column(name="Bdate")
	private LocalDateTime birtdate;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDateTime getBirtdate() {
		return birtdate;
	}

	public void setBirtdate(LocalDateTime birtdate) {
		this.birtdate = birtdate;
	}

	public Dependent(int ssn, Employee employee, String name, String sex, LocalDateTime birtdate) {
		super();
		this.sex = sex;
		this.birtdate = birtdate;
	}

	public Dependent() {
		super();
	}

	public DependentPrimaryKey getDependentKey() {
		return dependentKey;
	}

	public void setDependentKey(DependentPrimaryKey dependentKey) {
		this.dependentKey = dependentKey;
	}
	
	
	
}
