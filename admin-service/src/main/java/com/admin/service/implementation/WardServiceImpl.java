package com.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Ward;
import com.admin.repository.WardRepository;
import com.admin.service.WardService;


@Service
public class WardServiceImpl implements WardService {

	@Autowired
	WardRepository wardRepository;

	@Override
	//both save and update
	public void save(Ward ward) {
		wardRepository.save(ward);
	}

	@Override
	public Ward get(Long id) {
		Ward ward = wardRepository.getReferenceById(id);
		return ward;
	}
	public List<Ward> getAll() {
		 List<Ward> list=wardRepository.findAll();
		
		return list;
	}
	public void delete(long id) {
	wardRepository.deleteById(id);

	
	}

	

	
}
