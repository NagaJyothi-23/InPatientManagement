package com.admin.service;

import java.util.List;

import com.admin.bean.WardBean;
import com.admin.entity.Ward;

public interface WardService {


	WardBean getById(Long id);

	void delete(Long id);

	List<WardBean> getAll();

	List<Ward> findByMedicationId(Long medicationId);
	void update(WardBean wardBean);

	void save(WardBean wardBean);

}
