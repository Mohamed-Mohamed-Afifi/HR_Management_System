package com.afify.hr_system.repo.employee.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageFilter {
	private int pageNumber;
	private int pageSize;
	private SearchArgs searchArgs;
}
