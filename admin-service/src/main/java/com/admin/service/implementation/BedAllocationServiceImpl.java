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
	public BedAllocation getById(long id) {
		// TODO Auto-generated method stub
		return bedAllocationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
	}

	@Override
	public List<BedAllocation> getAll() {
		// TODO Auto-generated method stub
		return bedAllocationRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		bedAllocationRepository.deleteById(id);
		
	}

	@Override
	public void update(BedAllocation bedAllocation) {
		// TODO Auto-generated method stub
		BedAllocation bedAllocation1= bedAllocationRepository.getReferenceById(bedAllocation.getBedNo());
		bedAllocation1.setBedNo(bedAllocation.getBedNo());
		bedAllocation1.setStart_date(bedAllocation.getStart_date());
		bedAllocation1.setEnd_date(bedAllocation.getEnd_date());
		bedAllocation1.setNo_of_days(bedAllocation.getNo_of_days());
		bedAllocation1.setPatient_id(bedAllocation.getPatient_id());
		bedAllocation1.setRoomtype_id(bedAllocation.getRoomtype_id());
		bedAllocation1.setStatus(bedAllocation.getStatus());
		bedAllocationRepository.save(bedAllocation1);

	}

}
