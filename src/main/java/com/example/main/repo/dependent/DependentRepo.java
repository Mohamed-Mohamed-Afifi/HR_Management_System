package com.example.main.repo.dependent;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.dependent.Dependent;
import com.example.main.entity.dependent.DependentPrimaryKey;

public interface DependentRepo extends JpaRepository<Dependent, DependentPrimaryKey>{

}
