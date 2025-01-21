package com.afify.hr_system.Base.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.afify.hr_system.Base.repo.BaseRepo;

import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;

@MappedSuperclass
@RequiredArgsConstructor
public class BaseService<T,ID> {
	@Autowired
	private final BaseRepo<T, ID> baseRepo;
	
	public T getById(ID id) {
		return baseRepo.findById(id).get();
	}
}
