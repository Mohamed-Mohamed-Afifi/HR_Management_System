package com.example.main.modal;

public class Employee {
private Integer SSN;
private String Fname;
private String Lname;
private String Bdate;
private String Address;
private String Sex;
private Integer Salary;
private Integer Superssn;
private Integer Dno;
public Integer getSSN() {
	return SSN;
}
public void setSSN(Integer sSN) {
	SSN = sSN;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getBdate() {
	return Bdate;
}
public void setBdate(String bdate) {
	Bdate = bdate;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getSex() {
	return Sex;
}
public void setSex(String sex) {
	Sex = sex;
}
public Integer getSalary() {
	return Salary;
}
public void setSalary(Integer salary) {
	Salary = salary;
}
public Integer getSuperssn() {
	return Superssn;
}
public void setSuperssn(Integer superssn) {
	Superssn = superssn;
}
public Integer getDno() {
	return Dno;
}
public void setDno(Integer dno) {
	Dno = dno;
}
public Employee(Integer sSN, String fname, String lname, String bdate, String address, String sex, Integer salary,
		Integer superssn, Integer dno) {
	super();
	SSN = sSN;
	Fname = fname;
	Lname = lname;
	Bdate = bdate;
	Address = address;
	Sex = sex;
	Salary = salary;
	Superssn = superssn;
	Dno = dno;
}
public Employee() {
    // TODO Auto-generated constructor stub
}
}