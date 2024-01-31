package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.RoomTypeBean;
import com.admin.entity.RoomTypeEntity;
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
		roomTypeEntity.setWardId(roomTypeBean.getWardId());
	}

	public void entityToBean(List<RoomTypeEntity> listEntity,
			List<RoomTypeBean> listbean) {
		RoomTypeBean roomBean=new RoomTypeBean();
		for(RoomTypeEntity roomEntity:listEntity) {
			roomBean.setId(roomEntity.getId());
			roomBean.setName(roomEntity.getName());
			roomBean.setRoomPrice(roomEntity.getRoomPrice());
			roomBean.setRoomSharing(roomEntity.getRoomSharing());
			roomBean.setWardId(roomEntity.getWardId());
		}
	}

	public void entityToBean(RoomTypeEntity roomTypeEntity, RoomTypeBean roomTypeBean) {

		RoomTypeBean roomBean=new RoomTypeBean();
		roomBean.setId(roomTypeEntity.getId());
		roomBean.setName(roomTypeEntity.getName());
		roomBean.setRoomPrice(roomTypeEntity.getRoomPrice());
		roomBean.setRoomSharing(roomTypeEntity.getRoomSharing());
		roomBean.setWardId(roomTypeEntity.getWardId());

	}

	

}
