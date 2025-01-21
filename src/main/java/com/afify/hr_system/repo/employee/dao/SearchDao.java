package com.afify.hr_system.repo.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SearchDao implements Specification<Employee> {
    private SearchArgs searchArgs;

    public SearchDao(SearchArgs searchArgs) {
        this.searchArgs = searchArgs;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        // Ensure searchArgs is not null
        if (searchArgs == null) {
            return cb.conjunction(); // Return an always-true predicate if no searchArgs
        }

        // Initialize predicates list
        List<Predicate> predicates = new ArrayList<>();
        Join<Employee, Department> empDept = root.join("department", JoinType.LEFT);
        Join<Employee, Employee> empMang = root.join("manager", JoinType.LEFT);

        // Check for ssn
        if (searchArgs.getSsn() != null) {
            predicates.add(cb.equal(root.get("ssn"), searchArgs.getSsn()));
        }

        // Check for sex
        if (searchArgs.getSex() != null && !searchArgs.getSex().isEmpty()) {
            predicates.add(cb.like(root.get("sex"), "%" + searchArgs.getSex() + "%"));
        }

        // Check for full_name
        if (searchArgs.getFull_name() != null && !searchArgs.getFull_name().isEmpty()) {
            String[] nameParts = searchArgs.getFull_name().trim().split("\\s+");
            if (nameParts.length >= 1 && !nameParts[0].isEmpty()) {
                predicates.add(cb.like(root.get("fname"), "%" + nameParts[0] + "%"));
            }
            if (nameParts.length >= 2 && !nameParts[1].isEmpty()) {
                predicates.add(cb.like(root.get("lname"), "%" + nameParts[1] + "%"));
            }
        }

        // Check for address
        if (searchArgs.getAddress() != null && !searchArgs.getAddress().isEmpty()) {
            predicates.add(cb.like(root.get("address"), "%" + searchArgs.getAddress() + "%"));
        }

        // Check for birthdate
        if (searchArgs.getBirthdate() != null) {
            predicates.add(cb.equal(root.get("bdate"), searchArgs.getBirthdate()));
        }

        // Check for salary
        if (searchArgs.getSalary() != null) {
            predicates.add(cb.equal(root.get("salary"), searchArgs.getSalary()));
        }

        // Check for department name
        if (searchArgs.getDepartmentName() != null && !searchArgs.getDepartmentName().isEmpty()) {
            predicates.add(cb.like(empDept.get("dname"), "%" + searchArgs.getDepartmentName() + "%"));
        }

        // Check for manager ssn
        if (searchArgs.getManager_ssn() != null) {
            predicates.add(cb.equal(empMang.get("ssn"), searchArgs.getManager_ssn()));
        }

        // Combine predicates with AND (change to cb.or for OR logic)
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
