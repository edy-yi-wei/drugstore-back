package com.jimin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimin.model.Apoteker;

@Repository
public interface ApotekerRepository extends JpaRepository<Apoteker, Long>{
	
	Page<Apoteker> findByNamaContainingAllIgnoreCase(String nama, Pageable page);
}
