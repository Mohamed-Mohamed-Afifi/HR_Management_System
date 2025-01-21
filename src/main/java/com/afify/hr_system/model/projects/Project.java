package com.afify.hr_system.model.projects;

import java.util.Set;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@NotNull
	@Id
	@Column(name="Pnumber")
	private int pnum;
	@NotBlank
	@Column(name="Pname")
	private String pname;
	@NotBlank
	@Column(name="Plocation")
	private String location;
	@NotBlank
	@Column(name="City")
	private String city;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="Dnum")
	private Department department;
	@ManyToMany(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
	@JoinTable(name="project_employees",
			joinColumns = @JoinColumn(name="pno"),
			inverseJoinColumns = @JoinColumn(name="essn")
			 )
	private Set<Employee> employees;
	
}
