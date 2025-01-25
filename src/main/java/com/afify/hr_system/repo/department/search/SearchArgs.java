package com.afify.hr_system.repo.department.search;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SearchArgs {

	private LocalDateTime mgsStartDate;
	private Integer supervisorSsn;
	private String employeeName;
	private String projectName;
	private Integer dnum;
	private String dname;
	private String supervisorName;
}
