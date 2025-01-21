package com.afify.hr_system.model.dependent;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	@EmbeddedId
	private DependentPrimaryKey dependentId;
	
	@NotBlank
	@Column(name="Sex")
	private String sex;
	@NotNull
	@Column(name="Bdate")
	private LocalDateTime bdate;


	
	
}
