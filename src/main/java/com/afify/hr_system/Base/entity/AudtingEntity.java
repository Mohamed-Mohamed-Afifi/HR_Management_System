package com.afify.hr_system.Base.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.Data;

@Data
public abstract class AudtingEntity {

	@CreatedDate
	@Column(
			nullable = false,
			updatable = false
			)
	protected LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(
			insertable = false
			)
	protected LocalDateTime lastModifiedDate;
}
