package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Medication;
import com.admin.entity.Ward;
import com.admin.service.MedicationService;

@RestController
@RequestMapping("/medication")
public class MedicationController {

	@Autowired
	MedicationService medicationService;
	
	@PostMapping("/save")
	public ResponseEntity<Medication> save(@RequestBody Medication medication) {
		medicationService.save(medication);
		ResponseEntity<Medication> responseEntity = new ResponseEntity<>(medication, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Medication> getById(@PathVariable long id) {
		Medication medication=medicationService.getById(id);
		ResponseEntity<Medication> responseEntity = new ResponseEntity<>(medication, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Medication>> getAll() {
		List<Medication> list=medicationService.getAll();
		ResponseEntity<List<Medication>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public  ResponseEntity deleteById(@PathVariable long id)
	{
		medicationService.delete(id);
		ResponseEntity responseEntity=new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping
	public ResponseEntity<Medication> put(@RequestBody Medication medication) throws Exception {

		Medication medication1 = medicationService.getById(medication.getId());
		if (medication1 != null) {
			medication1.setMedicationName(medication.getMedicationName());
			medicationService.save(medication1);
		}
		ResponseEntity<Medication> responseEntity = new ResponseEntity<>(medication1, HttpStatus.OK);
		return responseEntity;
	}
}
	

