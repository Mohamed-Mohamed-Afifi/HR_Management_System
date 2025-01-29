package com.afify.hr_system.model.projects;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPageDto {
private List<ProjectDto> projects;
private int pageNumber;
private int pageSize;
private int totalPages;
}
