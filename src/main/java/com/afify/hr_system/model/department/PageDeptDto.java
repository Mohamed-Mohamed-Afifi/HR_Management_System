package com.afify.hr_system.model.department;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDeptDto {
	private List<DepartDto> departments;
	private int page_number;
	private int page_size;
	private int totalPages;
}
