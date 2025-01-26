package com.afify.hr_system.repo.userAuth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.appUser.AppRole;

public interface RoleRepo extends JpaRepository<AppRole, Integer>{

}
