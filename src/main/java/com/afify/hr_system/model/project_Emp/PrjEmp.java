package com.afify.hr_system.model.project_Emp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name="project_employees")
@Entity
public class PrjEmp {
	@EmbeddedId
	private PrjEmpKey prjEmpKey;
	
	@Column(name="hours")
	private int hours;

	public PrjEmpKey getPrjEmpKey() {
		return prjEmpKey;
	}

	public void setPrjEmpKey(PrjEmpKey prjEmpKey) {
		this.prjEmpKey = prjEmpKey;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public PrjEmp(PrjEmpKey prjEmpKey, int hours) {
		super();
		this.prjEmpKey = prjEmpKey;
		this.hours = hours;
	}

	public PrjEmp() {
		super();
	}
	
	
}
