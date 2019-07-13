package com.jimin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jimin.model.Pasien;
import com.jimin.repository.PasienRepository;

@Service
public class PasienService {
	@Autowired
	private PasienRepository repo;
	
	public Pasien save(Pasien pasien) {
		Pasien result = repo.save(pasien);
		return result;
	}
	
	public Pasien getPasien(Long id) {
		return repo.findById(id).get();
	}
	
	public Page<Pasien> selectPasien(String search, int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber-1, pageSize);
		return repo.findByNamaContainingOrRmNumberContainingOrAlamatContainingOrNoHpContainingAllIgnoreCase(search, search, search, search, page);
	}
}
