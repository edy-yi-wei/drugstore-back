package com.jimin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jimin.model.Apoteker;
import com.jimin.repository.ApotekerRepository;

@Service
public class ApotekerService {
	@Autowired
	private ApotekerRepository repo;
		
	public Apoteker save(Apoteker apoteker){
		Apoteker result = repo.save(apoteker);
		return result;
	}
	
	public Apoteker getApoteker(Long id) {
		return repo.findById(id).get();
	}
	
	public Page<Apoteker> selectApoteker(String search, int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber-1, pageSize);
		return repo.findByNamaContainingAllIgnoreCase(search, page);
	}
}
