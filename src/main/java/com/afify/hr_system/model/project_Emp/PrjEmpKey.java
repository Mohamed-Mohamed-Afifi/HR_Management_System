package com.afify.hr_system.model.project_Emp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PrjEmpKey {
	@Column(name="essn")
	private int essn;
	@Column(name="pno")
	private int pno;
	public int getEssn() {
		return essn;
	}
	public void setEssn(int essn) {
		this.essn = essn;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public PrjEmpKey(int essn, int pno) {
		super();
		this.essn = essn;
		this.pno = pno;
	}
	public PrjEmpKey() {
		super();
	}
	
}
