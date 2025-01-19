package com.afify.hr_system.model.dependent;

import com.afify.hr_system.model.employee.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ESSN")
	private Employee employee;


	
	
}
