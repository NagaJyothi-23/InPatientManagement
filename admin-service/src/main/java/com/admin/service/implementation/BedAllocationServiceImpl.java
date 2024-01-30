package com.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.BedAllocation;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.BedAllocationRepository;
import com.admin.service.BedAllocationService;

@Service
public class BedAllocationServiceImpl implements BedAllocationService{

	@Autowired
	BedAllocationRepository bedAllocationRepository; 
	@Override
	public BedAllocation save(BedAllocation bedAllocation) {
		// TODO Auto-generated method stub
		return bedAllocationRepository.save( bedAllocation);
	}

	@Override
	public BedAllocation getById(int id) {
		// TODO Auto-generated method stub
		return bedAllocationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
	}

	@Override
	public List<BedAllocation> getAll() {
		// TODO Auto-generated method stub
		return bedAllocationRepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bedAllocationRepository.deleteById(id);
		
	}

	@Override
	public void update(BedAllocation bedAllocation) {
		// TODO Auto-generated method stub
		BedAllocation bedAllocation1= bedAllocationRepository.getReferenceById(bedAllocation.getBedAllocationId());
		bedAllocation1.setBedAllocationId(bedAllocation.getBedAllocationId());
		bedAllocation1.setStartDate(bedAllocation.getStartDate());
		bedAllocation1.setEndDate(bedAllocation.getEndDate());
		bedAllocation1.setNoOfDays(bedAllocation.getNoOfDays());
		bedAllocation1.setPatientId(bedAllocation.getPatientId());
		bedAllocation1.setRoomtypeId(bedAllocation.getRoomtypeId());
		bedAllocation1.setStatus(bedAllocation.getStatus());
		bedAllocationRepository.save(bedAllocation1);

	}

}
