package com.patient.serviceImplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.PatientEntity;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientService;
@Service
public class PatientServiceImplementation implements PatientService{
	@Autowired
	private PatientRepository patientRepository;
	

	@Override
	public void save(PatientEntity patientRegistration) {
		patientRepository.save(patientRegistration);
		
	}


	@Override
	public List<PatientEntity> getDetails() {
	
		return patientRepository.findAll();
	}	

	@Override
	public void delete(Integer id) {
		
		 patientRepository.deleteById(id);
		
	}



	@Override
	public void update(PatientEntity patientRegistration) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PatientEntity getPatientById(Integer id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElse(null);
	}


	
//	@Override
//	public void update(PatientRegistrationEntity patientRegistration) {
//	
//		
//	}
	
	
	
}



