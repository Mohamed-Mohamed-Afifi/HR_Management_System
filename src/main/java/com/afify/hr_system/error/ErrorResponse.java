package com.afify.hr_system.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private String massage;
	private Boolean  sucess;
	private Integer status;
	private List<String> errors;
	private LocalDateTime localDateTime;
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponse(String massage,Integer status) {
		super();
		this.massage = massage;
		this.sucess = false;
		this.status=status;
		this.localDateTime = LocalDateTime.now();
		this.errors=new ArrayList<String>();
		errors.add(massage);
	}
//	Used in validator
	public ErrorResponse(String massage,Integer status,List<String> errors) {
		super();
		this.massage = massage;
		this.sucess = false;
		this.status=status;
		this.localDateTime = LocalDateTime.now();
		this.errors=errors;
	}
}
