package com.jimin.restapi;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimin.model.Pasien;
import com.jimin.service.PasienService;

@RestController
@RequestMapping("/drugstore")
public class PasienController {
	@Autowired
	private PasienService service;
	
	@RequestMapping(value = "/pasiens", method = RequestMethod.POST)
	public ResponseEntity<List<String>> savePasien(@Valid @RequestBody Pasien pasien) {
		List<String> result = new ArrayList<>();
		try {
			Pasien entity = service.save(pasien);
			if(entity!=null) {
				result.add("Pasien berhasil disimpan!");
				return new ResponseEntity<List<String>>(result, HttpStatus.OK);
			} else {
				result.add("Gagal menyimpan data Pasien");
				return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			result.add("ERROR - "+ex.getMessage());
			return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/pasiens", method = RequestMethod.GET)
	public Page<Pasien> selectPasien(@RequestParam(name = "search", required = false) String search, @RequestParam(name = "pageNumber", required = true) int pageNumber){
		try {
			Page<Pasien> list = service.selectPasien(search, pageNumber, com.jimin.Constant.ROW_PER_PAGE);
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/pasiens/{id}", method = RequestMethod.GET)
	public Pasien getPasien(@PathVariable("id") Long id) {
		try {
			return service.getPasien(id);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
