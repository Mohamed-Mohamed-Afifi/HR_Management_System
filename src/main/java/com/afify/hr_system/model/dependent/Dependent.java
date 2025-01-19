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


	
	
}
