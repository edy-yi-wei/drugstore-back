package com.jimin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimin.model.Pasien;

@Repository
public interface PasienRepository extends JpaRepository<Pasien, Long>{
	Page<Pasien> findByNamaContainingOrRmNumberContainingOrAlamatContainingOrNoHpContainingAllIgnoreCase(String nama, String rmNumber, String alamat, String noHp, Pageable page);
}
