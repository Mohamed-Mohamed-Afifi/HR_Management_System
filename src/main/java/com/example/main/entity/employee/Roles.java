package com.example.main.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {
	@Id
	@Column(name="role_name")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Roles(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Roles() {
		super();
	}
	
	
}
