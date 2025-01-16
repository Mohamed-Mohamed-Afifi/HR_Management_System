package com.afify.hr_system.model.dependent;

import java.time.LocalDateTime;

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
@Entity
@Table(name="Dependent")
public class Dependent {
	@EmbeddedId
	private DependentPrimaryKey dependentId;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="Bdate")
	private LocalDateTime bdate;

//	public DependentPrimaryKey getDependentId() {
//		return dependentId;
//	}
//
//	public void setDependentId(DependentPrimaryKey dependentId) {
//		this.dependentId = dependentId;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//	public LocalDateTime getBdate() {
//		return bdate;
//	}
//
//	public void setBdate(LocalDateTime bdate) {
//		this.bdate = bdate;
//	}
//
//	public Dependent(DependentPrimaryKey dependentId, String sex, LocalDateTime bdate) {
//		super();
//		this.dependentId = dependentId;
//		this.sex = sex;
//		this.bdate = bdate;
//	}
//
//	public Dependent() {
//		super();
//	}
	
	
}
