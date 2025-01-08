package com.example.main.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
@Id
@Column(name="SSN")
private Integer ssn;
@Column(name="Fname")
private String fname;
@Column(name="Lname")
private String lname;
@Column(name="Bdate")
private String birthDate;
@Column(name="Address")
private String address;
@Column(name="Sex")
private String sex;
@Column(name="Salary")
private Integer salary;
@ManyToMany(cascade =CascadeType.ALL)
@JoinTable(
		name="Emp_role",
		joinColumns =@JoinColumn(name="Emp_id"),
		inverseJoinColumns = @JoinColumn(name="Role_name")
		  )
private Set<Roles> roles;

@ManyToOne
@JoinColumn(name="Superssn")
private Employee manager;
@JsonIgnore
@JsonManagedReference
@OneToMany(mappedBy = "manager")
private List<Employee> sub_emp;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="Dno")
@JsonBackReference
private Departments department;
@JsonIgnore
@OneToMany(mappedBy = "managerOfDept")
private List<Departments> deptManaged;
@ManyToMany
@JoinTable(name="Works_for",
			joinColumns =@JoinColumn(name="Essn"),
			inverseJoinColumns = @JoinColumn(name="Pno",referencedColumnName = "Pnumber"))
private Set<Project> projects;

@OneToMany(mappedBy = "dependentKey.employee")
@JsonManagedReference
private List<Dependent> dependents;

public List<Dependent> getDependents() {
	return dependents;
}
public void setDependents(List<Dependent> dependents) {
	this.dependents = dependents;
}
public Set<Roles> getRoles() {
	return roles;
}
public void setRoles(Set<Roles> roles) {
	this.roles = roles;
}
public Set<Project> getProjects() {
	return projects;
}
public void setProjects(Set<Project> projects) {
	this.projects = projects;
}
public List<Departments> getDeptManaged() {
	return deptManaged;
}
public void setDeptManaged(List<Departments> deptManaged) {
	this.deptManaged = deptManaged;
}
public Integer getSsn() {
	return ssn;
}
public void setSsn(Integer ssn) {
	this.ssn = ssn;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
public Employee(Integer ssn, String fname, String lname, String birthDate, String address, String sex, Integer salary,
		Integer superssn) {
	super();
	this.ssn = ssn;
	this.fname = fname;
	this.lname = lname;
	this.birthDate = birthDate;
	this.address = address;
	this.sex = sex;
	this.salary = salary;
//	this.superssn = superssn;
}
public Employee() {
	super();
}
public Employee getManager() {
	return manager;
}
public void setManager(Employee manager) {
	this.manager = manager;
}
public List<Employee> getSub_emp() {
	return sub_emp;
}
public void setSub_emp(List<Employee> sub_emp) {
	this.sub_emp = sub_emp;
}
public Departments getDepartment() {
	return department;
}
public void setDepartment(Departments department) {
	this.department = department;
}


}
