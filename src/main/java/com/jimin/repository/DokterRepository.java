package com.jimin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimin.model.Dokter;

@Repository
public interface DokterRepository extends JpaRepository<Dokter, Long>{
	Page<Dokter> findByNamaContainingOrSpesialisContainingAllIgnoreCase(String nama, String spesialis, Pageable page);
}
