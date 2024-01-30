package com.admin.service.implementation;

import java.util.List;

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

	public RoomTypeEntity convertBeantoEntity(RoomTypeBean bean) {
		RoomTypeEntity entity = new RoomTypeEntity();
		entity.setRoomType_id(bean.getRoomType_id());
		entity.setRoomType_name(bean.getRoomType_name());
		entity.setRoomSharing(bean.getRoomSharing());
		entity.setRoomPrice(bean.getRoomPrice());
		entity.setWard_id(bean.getWard_id());
		return entity;
	}

	@Override
	public void save(RoomTypeEntity roomType) {
		roomTypeRepository.save(roomType);
	}

	@Override
	public List<RoomTypeEntity> getAll() {
		List<RoomTypeEntity> roomlist = roomTypeRepository.findAll();
		return roomlist;

	}

	@Override
	public RoomTypeEntity getById(long id) {
		return roomTypeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Room not found with id" + id));
	}

	public RoomTypeBean convertEntitytoBean(RoomTypeEntity entity) {
		RoomTypeBean bean = new RoomTypeBean();
		bean.setRoomType_id(entity.getRoomType_id());
		bean.setRoomType_name(entity.getRoomType_name());
		bean.setRoomSharing(entity.getRoomSharing());
		bean.setRoomPrice(entity.getRoomPrice());
		bean.setWard_id(entity.getWard_id());
		return bean;
	}

	@Override
	public RoomTypeEntity update(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		roomTypeRepository.deleteById(id);

	}

}
