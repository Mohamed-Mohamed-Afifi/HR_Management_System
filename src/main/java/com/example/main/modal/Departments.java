package com.example.main.modal;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Departments")
public class Departments {
	@Id
	@Column("Dnum")
	private Integer departmentNumber;
	@Column("Dname")
	private String departmentName;
	@Column("MGRSSN")
	private Integer managerSSN;
	@Column("MGRStart Date")
	private LocalDateTime managerStartDate;

	public Departments() {
		super();
	}

	public Departments(Integer departmentNumber, String departmentName, Integer managerSSN, LocalDateTime managerStartDate) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.managerSSN = managerSSN;
		this.managerStartDate = managerStartDate;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerSSN() {
		return managerSSN;
	}

	public void setManagerSSN(Integer managerSSN) {
		this.managerSSN = managerSSN;
	}

	public LocalDateTime getManagerStartDate() {
		return managerStartDate;
	}

	public void setManagerStartDate(LocalDateTime managerStartDate) {
		this.managerStartDate = managerStartDate;
	}
	

}
