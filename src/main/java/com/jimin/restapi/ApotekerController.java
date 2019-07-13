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

import com.jimin.model.Apoteker;
import com.jimin.service.ApotekerService;

@RestController
@RequestMapping("/drugstore")
public class ApotekerController {
	@Autowired
	private ApotekerService service;
	
	@RequestMapping(value = "/apotekers", method = RequestMethod.POST)
	public ResponseEntity<List<String>> saveApoteker(@Valid @RequestBody Apoteker apoteker) {
		List<String> result = new ArrayList<>();
		try {
			Apoteker entity = service.save(apoteker);			
			if(entity!=null) {			
				result.add("Apoteker berhasil disimpan!");
				return new ResponseEntity<List<String>>(result, HttpStatus.OK);
			} else {
				result.add("Gagal menyimpan data Apoteker!");
				return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			result.add("ERROR - "+ex.getMessage());
			return new ResponseEntity<List<String>>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/apotekers", method = RequestMethod.GET)
	public Page<Apoteker> selectApoteker(@RequestParam(name = "search", required = false) String search, @RequestParam(name = "pageNumber", required = true) int pageNumber){
		try {
			Page<Apoteker> list = service.selectApoteker(search, pageNumber, com.jimin.Constant.ROW_PER_PAGE);
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/apotekers/{id}", method = RequestMethod.GET)
	public Apoteker getApoteker(@PathVariable("id") Long id) {
		try {
			return service.getApoteker(id);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
