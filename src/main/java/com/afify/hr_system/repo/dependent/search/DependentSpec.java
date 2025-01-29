package com.afify.hr_system.repo.dependent.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.afify.hr_system.model.dependent.Dependent;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class DependentSpec implements Specification<Dependent>{
	private SearchArgs searchArgs;
	public DependentSpec(SearchArgs searchArgs) {
		this.searchArgs=searchArgs;
	}
	@Override
	public Predicate toPredicate(Root<Dependent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates=new ArrayList<>();
		
		if(searchArgs.getDependentName()!=null &&!searchArgs.getDependentName().isEmpty()) {
			predicates.add(cb.like(root.get("dependentId").get("depname"), searchArgs.getDependentName()));
		}
		if(searchArgs.getEmployeeSsn()!=null) {
			predicates.add(cb.equal(root.get("dependentId").get("employeeSsn"), searchArgs.getEmployeeSsn()));
		}
		
		return cb.or(predicates.toArray(new Predicate[0]));
	}

}
