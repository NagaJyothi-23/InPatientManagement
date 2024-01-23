package com.admin.service.implimentation;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Medication;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.MedicationRepository;
import com.admin.service.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService{

	@Autowired
	MedicationRepository medicationRepository;
	@Override
	public Medication save(Medication medication) {
		// TODO Auto-generated method stub
		 medicationRepository.save(medication);
		 return medication;
	}
	@Override
	public Medication getById(long id) {
		// TODO Auto-generated method stub
		Medication medication= medicationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
		return medication;
	}
	@Override
	public List<Medication> getAll() {
		// TODO Auto-generated method stub
		 List<Medication> list=medicationRepository.findAll();
		
		return list;
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
	medicationRepository.deleteById(id);
	
	}

	

}
