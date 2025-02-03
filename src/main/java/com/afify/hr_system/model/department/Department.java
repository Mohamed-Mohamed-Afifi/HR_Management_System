package com.afify.hr_system.model.department;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.model.projects.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@EntityListeners(AuditingEntityListener.class)
public class Department {
	@NotNull
	@Id
	@Column(name="Dnum")
	private Integer departmentNumber;
	@NotBlank
	@Column(name="Dname")
	private String dname;
	@NotNull
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


	@CreatedDate
	@Column(
			updatable = false,
			nullable = false
			)
	@CreationTimestamp
	private LocalDateTime created_at;
	
	@LastModifiedDate
	@Column(
			insertable = false
			)
	private LocalDateTime lastModified;
	@CreatedBy
	@Column(
			updatable = false,
			nullable = false
			)
	private String created_by;
	
	@LastModifiedBy
	@Column(
			insertable = false
			)
	private String lastModified_by;
}
