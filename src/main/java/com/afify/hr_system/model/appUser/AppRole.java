package com.afify.hr_system.model.appUser;

import com.afify.hr_system.Base.entity.AudtingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppRole extends AudtingEntity{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
}
