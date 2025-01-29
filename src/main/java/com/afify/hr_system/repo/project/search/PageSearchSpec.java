package com.afify.hr_system.repo.project.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageSearchSpec {

	private SearchArgs searchArgs;
	private int pageNum;
	private int pageSize;
}
