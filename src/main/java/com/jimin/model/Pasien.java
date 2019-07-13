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
@Table(name = "tbl_pasien")
public class Pasien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pasien")
	private Long idPasien;
	
	@Column(name = "rm_number")
	@NotBlank(message = "Anda belum mengisi nomor RM pasien")
	private String rmNumber;
	
	@Column(name = "nama")
	@NotBlank(message = "Anda belum mengisi nama pasien")
	private String nama;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Column(name = "tanggal_lahir")
	private Date tanggalLahir;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "nama_ibu")
	private String namaIbu;
	
	@Column(name = "noHp")
	private String noHp;
	
	@Column(name = "deleted")
	private boolean delete;
}
