package com.jimin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jimin.model.Dokter;
import com.jimin.repository.DokterRepository;

@Service
public class DokterService {
	@Autowired
	private DokterRepository repo;
	
	public Dokter save(Dokter dokter) {
		Dokter result = repo.save(dokter);
		return result;
	}
	
	public Dokter getDokter(Long id) {
		return repo.findById(id).get();
	}
	
	public Page<Dokter> selectDokter(String search, int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber-1, pageSize);
		return repo.findByNamaContainingOrSpesialisContainingAllIgnoreCase(search, search, page);
	}
}
