package com.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.RoomTypeEntity;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.RoomTypeRepository;
import com.admin.service.RoomTypeService;
@Service
public class RoomTypeServiceImplementation implements RoomTypeService{

	@Autowired
	RoomTypeRepository roomTypeRepository;

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
		return roomTypeRepository.findById(id).orElseThrow(()->
		new RecordNotFoundException("Room not found with id"+id));		
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
