package com.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.admin.bean.MedicationBean;
import com.admin.entity.Medication;
import com.admin.exception.RecordNotFoundException;
import com.admin.service.MedicationService;

@RestController
@RequestMapping("/medication")
public class MedicationController {

	@Autowired
	MedicationService medicationService;
	private static Logger log = LoggerFactory.getLogger(MedicationController.class.getSimpleName());

	@PostMapping("/save")
	public ResponseEntity<MedicationBean> save(@RequestBody MedicationBean medication) {
		log.info("Saving Medication entity");
		try {
			medicationService.save(medication);
			ResponseEntity<MedicationBean> responseEntity = new ResponseEntity<>(medication, HttpStatus.CREATED);
			log.info("Saving Medication entity is done");
			return responseEntity;
		} catch (Exception e) {
			log.error("error handled");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<MedicationBean> getById(@PathVariable long id) {
		log.info("Fetching Medication by Id");
		
			MedicationBean medication = medicationService.getById(id);
			ResponseEntity<MedicationBean> responseEntity = new ResponseEntity<>(medication, HttpStatus.OK);
			log.info("Fetching Medication by Id is done");
			return responseEntity;
		
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<MedicationBean>> getAll() {
		log.info("Fetching All Medication details");
	
			List<MedicationBean> list = medicationService.getAll();
			ResponseEntity<List<MedicationBean>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
			log.info("Fetching All Medication details is done");
			return responseEntity;
		
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		log.info("Deleting Medication by ID");
		try {
			medicationService.delete(id);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
			log.info("Deleting Medication by ID is done");
			return responseEntity;
		} catch (RecordNotFoundException e) {
			log.error("error handled");
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> put(@RequestBody Medication medication,@PathVariable long id) throws Exception {

		log.info("Updating Medication");
		try {
			MedicationBean medication1 = medicationService.getById(id);
			if (medication1 != null) {
				medication1.setMedicationName(medication.getMedicationName());
				medicationService.save(medication1);
			}
			ResponseEntity<String> responseEntity = new ResponseEntity<>("MedicationType updated Successfully", HttpStatus.OK);
			log.info("Updating Medication is done");
			return responseEntity;
		} catch (RecordNotFoundException e) {
			log.error("error handled");
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
