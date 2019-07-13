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
@Table(name = "tbl_apoteker")
public class Apoteker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_apoteker")
	private Long idApoteker;
	
	@Column(name = "nama")
	@NotBlank(message = "Anda belum mengisi nama apoteker")
	private String nama;
	
	@Column(name = "sik_sipa")
	private String sikSipa;
	
	@Column(name = "stra")
	private String stra;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "jabatan")
	private String jabatan;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "deleted")
	private boolean delete;
}
