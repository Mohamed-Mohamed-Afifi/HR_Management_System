package com.afify.hr_system.model.appUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="token")
	private String token;
	
	@Column(name="is_expired")
	private boolean is_expired;
	@Column(name="is_revocked")
	private boolean is_revocked;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private AppUser user;
}
