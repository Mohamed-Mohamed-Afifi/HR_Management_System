package com.afify.hr_system.repo.project.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchArgs {
	private Integer projectId;
	private String projectName;
	private String location;
	private String city;
	private Integer dnum;
	private String dname;
	private Integer empSsn;
	private String empName;
}
