package com.admin.service;

import java.util.List;

import com.admin.bean.BedAllocationBean;

public interface BedAllocationService {

	BedAllocationBean save(BedAllocationBean bedAllocationBean);
	BedAllocationBean getById(int id);
	List<BedAllocationBean> getAll();
	void delete(int id);
	void update(BedAllocationBean bedAllocationBean);
}
