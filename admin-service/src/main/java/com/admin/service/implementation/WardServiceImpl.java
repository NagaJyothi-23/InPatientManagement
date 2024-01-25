package com.admin.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.WardRepository;
import com.admin.service.WardService;

@Service
public class WardServiceImpl implements WardService {

	@Autowired
	WardRepository wardRepository;

	@Override
	public void save(Ward ward) {
		wardRepository.save(ward);
	}

	@Override
	public Ward get(int id) {
		Ward ward = wardRepository.getReferenceById(id);
		return ward;
	}
	public List<Ward> getAll() {
		 List<Ward> list=wardRepository.findAll();
		
		return list;
	}
//	public void delete(int id) {
//	wardRepository.deleteById(id);
//
//	
//	}
	public void delete(int id) {

		Optional<Ward> optional = wardRepository.findById(id);
		if (optional.isPresent()) {
			wardRepository.deleteById(id);
		} else
			optional.orElseThrow(() -> new RecordNotFoundException("record not found"));

	}
	public Ward update(Ward ward) {
		Optional<Ward> optional = wardRepository.findById(ward.getId());
		if(optional.isPresent()) {
	     wardRepository.save(ward);
		}else
			 optional.orElseThrow(()->new RecordNotFoundException("record not found"));
		return ward;
	}

	

	
}
