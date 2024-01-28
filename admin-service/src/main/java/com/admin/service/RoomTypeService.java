package com.admin.service;

import java.util.List;

import com.admin.entity.RoomTypeEntity;

public interface RoomTypeService {
	public void save(RoomTypeEntity roomTypeEntity);

	List<RoomTypeEntity> getAll();

	RoomTypeEntity getById(long id);

	RoomTypeEntity update(long id);

	public void delete(long id);
}
