package com.afify.hr_system.repo.department.search;

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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchDao implements Specification<Department> {
    private final SearchArgs searchArgs;

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        // Join with employees only if necessary
        if (searchArgs.getEmployeeName() != null && !searchArgs.getEmployeeName().isEmpty()) {
            Join<Department, Employee> deptEmp = root.join("employees", JoinType.INNER);

            // Split employee name into first and last
            String[] names = searchArgs.getEmployeeName().split(" ");
            if (names.length == 2) {
                // Add predicates for first and last name match
                predicates.add(cb.like(deptEmp.get("fname"), "%" + names[0] + "%"));
                predicates.add(cb.like(deptEmp.get("lname"), "%" + names[1] + "%"));
            }
        }

        // Join with supervisor only if supervisor ssn is provided
        if (searchArgs.getSupervisorSsn() != null) {
            Join<Department, Employee> deptManager = root.join("supervisor", JoinType.INNER);
            predicates.add(cb.equal(deptManager.get("ssn"), searchArgs.getSupervisorSsn()));
        }

        // Filter by department name if provided
        if (searchArgs.getDname() != null && !searchArgs.getDname().isEmpty()) {
            predicates.add(cb.like(root.get("dname"), "%" + searchArgs.getDname() + "%"));
        }

        // Return predicates combined with AND logic
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
