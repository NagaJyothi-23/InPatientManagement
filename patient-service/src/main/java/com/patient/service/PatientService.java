package com.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patient.entity.PatientEntity;


public interface PatientService {

	void save(PatientEntity patientEntity);
	
	List<PatientEntity> getDetails();
	
	PatientEntity getPatientById(Integer id);
	
	void delete(Integer id);

    void update(PatientEntity patientRegistration);

}

