package com.afify.hr_system.model.dependent;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)
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
