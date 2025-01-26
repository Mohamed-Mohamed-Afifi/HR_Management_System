package com.afify.hr_system.repo.userAuth;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.appUser.AppUser;

public interface UserRepo extends JpaRepository<AppUser,Integer>{
	
	@EntityGraph(attributePaths = {"roles"})
	AppUser findByUserName(String userName);
	
	@EntityGraph(attributePaths = {"roles"})
	List<AppUser> findAll();
	
	@EntityGraph(attributePaths = {"roles"})
	Optional<AppUser> findById(int id);

}
