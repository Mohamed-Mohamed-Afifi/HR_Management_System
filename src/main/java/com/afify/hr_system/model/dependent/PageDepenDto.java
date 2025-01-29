package com.afify.hr_system.model.dependent;

import java.util.List;

import lombok.Data;

@Data
public class PageDepenDto {
	List<DependentDto> dependents;
	private int page_number;
	private int page_size;
	private int totalPages;
	
}
