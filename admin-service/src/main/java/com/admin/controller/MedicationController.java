package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.bean.MedicationBean;
import com.admin.entity.Medication;
import com.admin.service.MedicationService;

@RestController
@RequestMapping("/medication")
public class MedicationController {

	@Autowired
	MedicationService medicationService;
	
	@PostMapping("/save")
	public ResponseEntity<MedicationBean> save(@RequestBody MedicationBean medication) {
		medicationService.save(medication);
		ResponseEntity<MedicationBean> responseEntity = new ResponseEntity<>(medication, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<MedicationBean> getById(@PathVariable long id) {
		MedicationBean medication=medicationService.getById(id);
		ResponseEntity<MedicationBean> responseEntity = new ResponseEntity<>(medication, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<MedicationBean>> getAll() {
		List<MedicationBean> list=medicationService.getAll();
		ResponseEntity<List<MedicationBean>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public  ResponseEntity<Medication> deleteById(@PathVariable long id)
	{
		medicationService.delete(id);
		ResponseEntity<Medication> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	
}
