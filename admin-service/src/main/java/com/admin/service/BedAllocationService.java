package com.admin.service;

import java.util.List;
import java.util.Optional;

import com.admin.entity.BedAllocation;

public interface BedAllocationService {

	BedAllocation save(BedAllocation bedAllocation);
	BedAllocation getById(int id);
	List<BedAllocation> getAll();
	void update(BedAllocation bedAllocation);
	void delete(int id);
}
