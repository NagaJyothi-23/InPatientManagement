package com.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patient.bean.PatientBean;
import com.patient.entity.PatientEntity;


public interface PatientService {

	void save(PatientBean patientBean);
	
	List<PatientBean> getAll();
	
	Optional<PatientEntity> getPatientById(Integer id);
	
	void delete(Integer id);

    void update(PatientBean patientRegistration);



}

