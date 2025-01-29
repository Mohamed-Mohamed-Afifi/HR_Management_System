package com.afify.hr_system.service.dependent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.afify.hr_system.mapper.dependent.DependentMapper;
import com.afify.hr_system.mapper.dependent.PageDependMapper;
import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentDto;
import com.afify.hr_system.model.dependent.DependentPrimaryKey;
import com.afify.hr_system.model.dependent.PageDepenDto;
import com.afify.hr_system.repo.dependent.DependentRepo;
import com.afify.hr_system.repo.dependent.search.DependentSpec;
import com.afify.hr_system.repo.dependent.search.PageSearchSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DependentService {
	private final DependentRepo dependentRepo;
	private final DependentMapper depnMapper;
	private final PageDependMapper pageDependMapper;
	
	public PageDepenDto getAlldependents(int pageNum,int pageSize){
		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Dependent> dendentPage=dependentRepo.findAll(pageable);
		PageDepenDto dependentsDto=pageDependMapper.map(dendentPage);
		return dependentsDto;
	}
	
	public ResponseEntity<?> addDependent(DependentDto depntDto){
		Dependent dependent=depnMapper.unmap(depntDto);
		dependentRepo.save(dependent);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> update(DependentDto depntDto){
		Dependent dependent=depnMapper.unmap(depntDto);
		dependentRepo.save(dependent);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> deleteById(DependentPrimaryKey id){
		dependentRepo.deleteById(id);
		return ResponseEntity.ok(null);
	} 
	public PageDepenDto filter(PageSearchSpec pageSearch){
		Pageable pageable=PageRequest.of(pageSearch.getPageNum(), pageSearch.getPageSize());
		DependentSpec dependentSpec=new DependentSpec(pageSearch.getSearchArgs());
		Page<Dependent> depnPage=dependentRepo.findAll(dependentSpec, pageable);
		PageDepenDto depenDto=pageDependMapper.map(depnPage);
		return depenDto;
	}
}
