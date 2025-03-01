package com.afify.hr_system.model.appUser.filter;

import com.afify.hr_system.model.appUser.AppUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpec implements Specification<AppUser> {
    private final UserSearchKeys userSearchKeys;

    public UserSpec(UserSearchKeys userSearchKeys) {
        this.userSearchKeys = userSearchKeys;
    }

    @Override
    public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates=new ArrayList<>();
        if(userSearchKeys.getFullName()!=null&&!userSearchKeys.getFullName().isEmpty() &&!userSearchKeys.getFullName().isBlank()){
            predicates.add(cb.like(root.get("fullName"),"%"+userSearchKeys.getFullName()+"%"));
        }
        if(userSearchKeys.getEmail()!=null&&!userSearchKeys.getEmail().isEmpty() &&!userSearchKeys.getEmail().isBlank()){
            predicates.add(cb.like(root.get("email"),"%"+userSearchKeys.getEmail()+"%"));
        }
        if(userSearchKeys.getRole()!=null){
            predicates.add(cb.equal(root.get("role"),userSearchKeys.getRole()));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
