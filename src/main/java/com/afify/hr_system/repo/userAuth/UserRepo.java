package com.afify.hr_system.repo.userAuth;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.appUser.AppUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepo extends JpaRepository<AppUser,Integer>, JpaSpecificationExecutor<AppUser> {
	
	@EntityGraph(attributePaths = {"tokens"})
	AppUser findByEmail(String userName);
	
	@EntityGraph(attributePaths = {"tokens"})
	List<AppUser> findAll();
	
	@EntityGraph(attributePaths = {"tokens"})
	Optional<AppUser> findById(int id);

}
