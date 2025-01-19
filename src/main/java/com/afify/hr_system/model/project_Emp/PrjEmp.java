package com.afify.hr_system.model.project_Emp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project_employees")
@Entity
public class PrjEmp {
	@EmbeddedId
	private PrjEmpKey prjEmpKey;
	
	@Column(name="hours")
	private int hours;
	
}
