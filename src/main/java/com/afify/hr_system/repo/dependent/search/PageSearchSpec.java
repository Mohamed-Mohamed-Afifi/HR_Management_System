package com.afify.hr_system.repo.dependent.search;

import lombok.Data;

@Data
public class PageSearchSpec {
	private SearchArgs searchArgs;
	private int pageNum;
	private int pageSize;
}
