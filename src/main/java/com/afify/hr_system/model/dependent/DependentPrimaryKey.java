package com.afify.hr_system.model.dependent;

import com.afify.hr_system.model.employee.Employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DependentPrimaryKey {
	
	@Column(name="Dependent_name")
	private String depname;
	
	@ManyToOne
	@JoinColumn(name="ESSN")
	private Employee employee;

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public DependentPrimaryKey(String depname, Employee employee) {
		super();
		this.depname = depname;
		this.employee = employee;
	}

	public DependentPrimaryKey() {
		super();
	} 
	
	
}
