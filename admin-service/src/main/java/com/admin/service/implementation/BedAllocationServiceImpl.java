package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.BedAllocationBean;
import com.admin.entity.BedAllocation;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.BedAllocationRepository;
import com.admin.service.BedAllocationService;

@Service
public class BedAllocationServiceImpl implements BedAllocationService{

	@Autowired
	BedAllocationRepository bedAllocationRepository; 
	@Override
	public BedAllocationBean save(BedAllocationBean bedAllocationBean) {
		// TODO Auto-generated method stub
		BedAllocation bedAllocation=new BedAllocation();
		beanToEntity(bedAllocationBean,bedAllocation);
	    bedAllocationRepository.save( bedAllocation);
	    return bedAllocationBean;
	}

	private void beanToEntity(BedAllocationBean bedAllocationBean, BedAllocation bedAllocation) {
		// TODO Auto-generated method stub
		bedAllocation.setId(bedAllocationBean.getId());
		bedAllocation.setRoomtypeId(bedAllocationBean.getRoomtypeId());
		bedAllocation.setPatientId(bedAllocationBean.getPatientId());
		bedAllocation.setNoOfDays(bedAllocationBean.getNoOfDays());
		bedAllocation.setStartDate(bedAllocationBean.getStartDate());
		bedAllocation.setEndDate(bedAllocationBean.getEndDate());
		bedAllocation.setStatus(bedAllocationBean.getStatus());
	}

	@Override
	public BedAllocationBean getById(int id) {
		// TODO Auto-generated method stub
		BedAllocation bedAllocation= bedAllocationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
		BedAllocationBean bedAllocationBean=new BedAllocationBean();
		entityToBean(bedAllocation,bedAllocationBean);
		return bedAllocationBean;
	}

	private void entityToBean(BedAllocation bedAllocation, BedAllocationBean bedAllocationBean) {
		// TODO Auto-generated method stub
		bedAllocationBean.setId(bedAllocation.getId());
		bedAllocationBean.setEndDate(bedAllocation.getEndDate());
		bedAllocationBean.setNoOfDays(bedAllocation.getNoOfDays());
		bedAllocationBean.setStartDate(bedAllocation.getStartDate());
		bedAllocationBean.setPatientId(bedAllocation.getPatientId());
		bedAllocationBean.setRoomtypeId(bedAllocation.getRoomtypeId());
		bedAllocationBean.setStatus(bedAllocation.getStatus());
	}

	@Override
	public List<BedAllocationBean> getAll() {
		// TODO Auto-generated method stub
		 List<BedAllocation> entityList= bedAllocationRepository.findAll();
		 List<BedAllocationBean> beanList=new ArrayList<>();
		 entityToBean(entityList,beanList);
		 return beanList;
	}

	private void entityToBean(List<BedAllocation> entitylist, List<BedAllocationBean> beanList) {
		// TODO Auto-generated method stub
		for(BedAllocation bedAllocation: entitylist)
		{
			BedAllocationBean bedAllocationBean=new BedAllocationBean();
			bedAllocationBean.setId(bedAllocation.getId());
			bedAllocationBean.setEndDate(bedAllocation.getEndDate());
			bedAllocationBean.setNoOfDays(bedAllocation.getNoOfDays());
			bedAllocationBean.setStartDate(bedAllocation.getStartDate());
			bedAllocationBean.setPatientId(bedAllocation.getPatientId());
			bedAllocationBean.setRoomtypeId(bedAllocation.getRoomtypeId());
			bedAllocationBean.setStatus(bedAllocation.getStatus());
			beanList.add(bedAllocationBean);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bedAllocationRepository.deleteById(id);
		
	}

	@Override
	public void update(BedAllocationBean bedAllocationBean) {
		// TODO Auto-generated method stub
		BedAllocation bedAllocation= bedAllocationRepository.getReferenceById(bedAllocationBean.getId());
		bedAllocation.setId(bedAllocationBean.getId());
		bedAllocation.setStartDate(bedAllocationBean.getStartDate());
		bedAllocation.setEndDate(bedAllocationBean.getEndDate());
		bedAllocation.setNoOfDays(bedAllocationBean.getNoOfDays());
		bedAllocation.setPatientId(bedAllocationBean.getPatientId());
		bedAllocation.setRoomtypeId(bedAllocationBean.getRoomtypeId());
		bedAllocation.setStatus(bedAllocationBean.getStatus());
		bedAllocationRepository.save(bedAllocation);

	}

}
