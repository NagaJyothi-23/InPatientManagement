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

import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;
import com.admin.service.WardService;

@RestController
@RequestMapping("/ward")

public class WardController {
	@Autowired
	private WardService wardService;

	@PostMapping("/save")
	public ResponseEntity<Ward> save(@RequestBody Ward ward) {
		System.out.println("coming");
		wardService.save(ward);
		ResponseEntity<Ward> responseEntity = new ResponseEntity<>(ward, HttpStatus.CREATED);
		return responseEntity;

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Ward> get(@PathVariable Long id) {
		Ward ward = wardService.get(id);

		ResponseEntity<Ward> responseEntity = new ResponseEntity<>(ward, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Ward>> getAll() {
		List<Ward> ward = wardService.getAll();

		return new ResponseEntity<List<Ward>>(ward, HttpStatus.OK);

	}
	@PutMapping
	public ResponseEntity<Ward> put(@RequestBody Ward ward) throws Exception {

		Ward ward1 = wardService.get(ward.getId());
		if (ward1 != null) {
			ward1.setName(ward.getName());
			ward1.setCapacity(ward.getCapacity());
			ward1.setAvailability(ward.getAvailability());
			ward1.setMedication_id(ward.getMedication_id());
			wardService.save(ward1);

		}
		ResponseEntity<Ward> responseEntity = new ResponseEntity<>(ward1, HttpStatus.OK);
		return responseEntity;
	}


	

	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Ward> delete(@PathVariable Long id) {
		wardService.delete(id);
		ResponseEntity<Ward> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

}
