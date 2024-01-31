package com.admin.service;

import java.util.List;
import java.util.Optional;

import com.admin.bean.RoomTypeBean;
import com.admin.entity.RoomTypeEntity;

public interface RoomTypeService {
	void save(RoomTypeBean roomTypeBean);
	List<RoomTypeBean> getAll();

	RoomTypeBean getById(long id);

	RoomTypeEntity update(long id);

	public void delete(long id);

	
}
