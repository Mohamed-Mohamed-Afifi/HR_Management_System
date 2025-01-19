package com.afify.hr_system.model.employee;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpPageDto {
    private List<EmpDTO> employees;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
