package com.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.admin.bean.WardBean;
import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;

public interface WardService {


	WardBean getById(Long id) throws RecordNotFoundException;

	void delete(Long id) throws RecordNotFoundException;

	List<WardBean> getAll();

	void update(WardBean wardBean) throws RecordNotFoundException;

	void save(WardBean wardBean);

}
