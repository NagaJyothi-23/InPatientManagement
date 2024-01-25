package com.patient.controller;

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

import com.patient.entity.PatientEntity;
import com.patient.service.PatientService;


@RestController
//@RequestMapping
public class PatientController {
@Autowired
private PatientService patientService;

@PostMapping("/save")
	public ResponseEntity<PatientEntity> save(@RequestBody PatientEntity patientEntity) {
	
	patientService.save(patientEntity);
	ResponseEntity<PatientEntity> responseEntity = new ResponseEntity<>(patientEntity,
			HttpStatus.OK);
	return responseEntity;
}

@GetMapping
public List<PatientEntity> getAll() {
  return patientService.getDetails();
}

@GetMapping("/{id}")
public ResponseEntity<PatientEntity> getPatientById(@PathVariable Integer id) {
  return ResponseEntity.ok(patientService.getPatientById(id));
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
	patientService.delete(id);
    return ResponseEntity.noContent().build();
}

}




