package com.afify.hr_system.repo.department.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptPageFilter {
	private SearchArgs searchArgs;
	private int pageNumber;
	private int pageSize;
}
