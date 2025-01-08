package com.example.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.Dependent;
import com.example.main.entity.DependentPrimaryKey;

public interface DependentRepo extends JpaRepository<Dependent, DependentPrimaryKey>{

}
