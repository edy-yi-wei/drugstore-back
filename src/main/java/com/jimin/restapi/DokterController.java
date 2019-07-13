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

import com.jimin.model.Dokter;
import com.jimin.service.DokterService;

@RestController
@RequestMapping("/drugstore")
public class DokterController {
	@Autowired
	private DokterService service;
	
	@RequestMapping(value = "/dokters", method = RequestMethod.POST)
	public ResponseEntity<List<String>> saveDokter(@Valid @RequestBody Dokter dokter) {
		List<String> result = new ArrayList<>();
		try {
			Dokter entity = service.save(dokter);
			if(entity!=null) {
				result.add("Dokter berhasil disimpan!");
				return new ResponseEntity<List<String>>(result, HttpStatus.OK);
			} else {
				result.add("Gagal menyimpan data Dokter");
				return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			result.add("ERROR - " + ex.getMessage());
			return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/dokters", method = RequestMethod.GET)
	public Page<Dokter> selectDokter(@RequestParam(name = "search", required = false) String search, @RequestParam(name = "pageNumber", required = true) int pageNumber){
		try {
			Page<Dokter> list = service.selectDokter(search, pageNumber, com.jimin.Constant.ROW_PER_PAGE);
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/dokters/{id}", method = RequestMethod.GET)
	public Dokter getDokter(@PathVariable("id") Long id) {
		try {
			return service.getDokter(id);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
