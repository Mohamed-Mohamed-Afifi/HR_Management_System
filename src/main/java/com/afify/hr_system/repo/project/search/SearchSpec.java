package com.afify.hr_system.repo.project.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.model.projects.Project;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SearchSpec implements Specification<Project> {

    private final SearchArgs searchArgs;

    public SearchSpec(SearchArgs searchArgs) {
        this.searchArgs = searchArgs;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        // Join with Department
        Join<Project, Department> prjDept = root.join("department", JoinType.LEFT); // Changed to LEFT to handle cases with null relationships
        if (searchArgs.getDnum() != null) {
            predicates.add(cb.equal(prjDept.get("departmentNumber"), searchArgs.getDnum()));
        }
        if (searchArgs.getDname() != null && !searchArgs.getDname().isEmpty()) {
            predicates.add(cb.like(cb.lower(prjDept.get("dname")), "%" + searchArgs.getDname().toLowerCase() + "%"));
        }

        // Join with Employee
        Join<Project, Employee> prjEmp = root.join("employees", JoinType.LEFT); // Changed to LEFT to handle cases with null relationships
        if (searchArgs.getEmpName() != null && !searchArgs.getEmpName().isEmpty()) {
            predicates.add(cb.like(cb.lower(prjEmp.get("fname")), "%" + searchArgs.getEmpName().toLowerCase() + "%"));
        }

        // Project name filter
        if (searchArgs.getProjectName() != null && !searchArgs.getProjectName().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("pname")), "%" + searchArgs.getProjectName().toLowerCase() + "%"));
        }

        // Combine predicates using AND logic
        return cb.or(predicates.toArray(new Predicate[0]));
    }
}
