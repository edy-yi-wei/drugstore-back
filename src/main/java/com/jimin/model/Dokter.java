package com.jimin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_dokter")
public class Dokter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dokter")
	private Long idDokter;
	
	@Column(name = "nama")
	@NotBlank(message = "Anda belum mengisi nama dokter")
	private String nama;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "spesialis")
	private String spesialis;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "deleted")
	private boolean delete;
}
