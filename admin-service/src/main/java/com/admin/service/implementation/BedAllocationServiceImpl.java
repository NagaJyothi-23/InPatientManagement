package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.BedAllocationBean;
import com.admin.bean.MedicationBean;
import com.admin.bean.RoomTypeBean;
import com.admin.bean.WardBean;
import com.admin.entity.BedAllocation;
import com.admin.entity.Medication;
import com.admin.entity.RoomTypeEntity;
import com.admin.entity.Ward;
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
		RoomTypeBean roomTypeBean=bedAllocationBean.getRoomTypeId();
		RoomTypeEntity roomTypeEntity=new RoomTypeEntity();
		beanToEntity(roomTypeEntity,roomTypeBean);
		bedAllocation.setRoomTypeId(roomTypeEntity);
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
		
		bedAllocationBean.setId(bedAllocation.getId());
		bedAllocationBean.setEndDate(bedAllocation.getEndDate());
		bedAllocationBean.setNoOfDays(bedAllocation.getNoOfDays());
		bedAllocationBean.setStartDate(bedAllocation.getStartDate());
		bedAllocationBean.setPatientId(bedAllocation.getPatientId());
		RoomTypeEntity roomTypeEntity=bedAllocation.getRoomTypeId();
		RoomTypeBean roomTypeBean=new RoomTypeBean(); 
		entityToBean(roomTypeEntity,roomTypeBean);
		bedAllocationBean.setRoomTypeId(roomTypeBean);
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
			RoomTypeBean roomTypeBean=new RoomTypeBean();
			RoomTypeEntity roomEntity=bedAllocation.getRoomTypeId();
			entityToBean(roomEntity, roomTypeBean);
			bedAllocationBean.setRoomTypeId(roomTypeBean);
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
		RoomTypeEntity roomTypeEntity=new RoomTypeEntity();
		RoomTypeBean roomTypeBean=bedAllocationBean.getRoomTypeId();
		beanToEntity(roomTypeEntity,roomTypeBean);
		bedAllocation.setRoomTypeId(roomTypeEntity);
		bedAllocation.setStatus(bedAllocationBean.getStatus());
		bedAllocationRepository.save(bedAllocation);

	}

	public void beanToEntity(RoomTypeEntity roomTypeEntity, RoomTypeBean roomTypeBean) {
		roomTypeEntity.setId(roomTypeBean.getId());
		roomTypeEntity.setName(roomTypeBean.getName());
		roomTypeEntity.setRoomPrice(roomTypeBean.getRoomPrice());
		roomTypeEntity.setRoomSharing(roomTypeBean.getRoomSharing());
		WardBean wardBean=roomTypeBean.getWardId();
		Ward entity=new Ward();
		beanToEntity(entity,wardBean);
		roomTypeEntity.setWardId(entity);
	}

	private void beanToEntity(Ward ward, WardBean wardBean) {
		ward.setId(wardBean.getId());
		ward.setName(wardBean.getName());
		ward.setCapacity(wardBean.getCapacity());
		ward.setAvailability(wardBean.getAvailability());
		MedicationBean medicationBean = wardBean.getMedicationId();
		Medication medication = new Medication();
		beanToEntity(medicationBean, medication);
		ward.setMedicationId(medication);

	}
	public void beanToEntity(MedicationBean medicationBean, Medication medication) {
		medication.setId(medicationBean.getId());
		medication.setMedicationName(medicationBean.getMedicationName());

	}
	
	public void entityToBean(RoomTypeEntity roomTypeEntity, RoomTypeBean roomTypeBean) {

	
		roomTypeBean.setId(roomTypeEntity.getId());
		roomTypeBean.setName(roomTypeEntity.getName());
		roomTypeBean.setRoomPrice(roomTypeEntity.getRoomPrice());
		roomTypeBean.setRoomSharing(roomTypeEntity.getRoomSharing());
		Ward entity=roomTypeEntity.getWardId();
		WardBean wardBean=new WardBean();
		entityToBean(wardBean, entity);
		roomTypeBean.setWardId(wardBean);

	}
	private void entityToBean(WardBean wardBean, Ward ward) {
		wardBean.setId(ward.getId());
		wardBean.setName(ward.getName());
		wardBean.setCapacity(ward.getCapacity());
		wardBean.setAvailability(ward.getAvailability());
		MedicationBean medicationBean = new MedicationBean();
		Medication medication = ward.getMedicationId();
		entityToBean(medication, medicationBean);
		wardBean.setMedicationId(medicationBean);

	}
	public void entityToBean(Medication medication, MedicationBean medicationBean) {
		medicationBean.setId(medication.getId());
		medicationBean.setMedicationName(medication.getMedicationName());
	}



}
