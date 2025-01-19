package com.afify.hr_system.model.project_Emp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PrjEmpKey {
	@Column(name="essn")
	private int essn;
	@Column(name="pno")
	private int pno;

	
}
