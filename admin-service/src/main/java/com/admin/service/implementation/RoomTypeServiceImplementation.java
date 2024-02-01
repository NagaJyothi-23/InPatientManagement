package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.MedicationBean;
import com.admin.bean.RoomTypeBean;
import com.admin.bean.WardBean;
import com.admin.entity.Medication;
import com.admin.entity.RoomTypeEntity;
import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.RoomTypeRepository;
import com.admin.service.RoomTypeService;

@Service
public class RoomTypeServiceImplementation implements RoomTypeService {

	@Autowired
	RoomTypeRepository roomTypeRepository;

	@Override
	public void save(RoomTypeBean roomTypeBean) {
		RoomTypeEntity roomTypeEntity=new RoomTypeEntity();
		beanToEntity(roomTypeEntity,roomTypeBean);
		roomTypeRepository.save(roomTypeEntity);

	}

	@Override
	public List<RoomTypeBean> getAll() {
		List<RoomTypeBean> roomTypeBean =new ArrayList<>();
		List<RoomTypeEntity> roomTypeEntity=roomTypeRepository.findAll();
		entityToBean(roomTypeEntity, roomTypeBean);
		return roomTypeBean;	
	}
	@Override
	public RoomTypeBean getById(long id) {
		RoomTypeBean roomTypeBean=new RoomTypeBean();
		RoomTypeEntity roomEntity=roomTypeRepository.findById(id).orElseThrow(()
				->new RecordNotFoundException("record not found"));
		entityToBean(roomEntity, roomTypeBean);
		return roomTypeBean;
				
	}

	
	@Override
	public RoomTypeEntity update(long id) {
	  RoomTypeEntity roomTypeId= roomTypeRepository.findById(id).orElseThrow(()
			  ->new RecordNotFoundException("record not found"));
		RoomTypeBean roomTypeBean=new RoomTypeBean();
		entityToBean(roomTypeId, roomTypeBean);
		return roomTypeId;
		
	}

	@Override
	public void delete(long id) {
		roomTypeRepository.deleteById(id);

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
	public void entityToBean(List<RoomTypeEntity> listEntity,
			List<RoomTypeBean> listbean) {
		RoomTypeBean roomBean=new RoomTypeBean();
		for(RoomTypeEntity roomEntity:listEntity) {
			roomBean.setId(roomEntity.getId());
			roomBean.setName(roomEntity.getName());
			roomBean.setRoomPrice(roomEntity.getRoomPrice());
			roomBean.setRoomSharing(roomEntity.getRoomSharing());
			WardBean wardBean=new WardBean();
			Ward entity=roomEntity.getWardId();
			entityToBean(wardBean, entity);
			roomBean.setWardId(wardBean);
			listbean.add(roomBean);		}
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
