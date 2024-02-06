package com.admin.service;

import java.util.List;

import com.admin.bean.WardBean;
import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;

public interface WardService {


	WardBean getById(Long id) throws RecordNotFoundException;

	void delete(Long id) throws RecordNotFoundException;

	List<WardBean> getAll();


	List<Ward> findByMedicationId(Long medicationId);
	void update(WardBean wardBean);
	void update(WardBean wardBean) throws RecordNotFoundException;


	void save(WardBean wardBean);

}
