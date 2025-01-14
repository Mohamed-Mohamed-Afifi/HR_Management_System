package com.afify.hr_system.model.projects;

import java.util.List;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	
	@Id
	@Column(name="Pnumber")
	private int pnum;
	
	@Column(name="Pname")
	private String pname;
	
	@Column(name="Plocation")
	private String location;
	
	@Column(name="City")
	private String city;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonBackReference
	@JoinColumn(name="Dnum")
	private Department department;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			joinColumns = @JoinColumn(name="pno"),
			inverseJoinColumns = @JoinColumn(name="essn")
			 )
	private List<Employee> employees;

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project(int pnum, String pname, String location, String city, Department department,
			List<Employee> employees) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.location = location;
		this.city = city;
		this.department = department;
		this.employees = employees;
	}

	public Project() {
		super();
	}
	
	
	
}
