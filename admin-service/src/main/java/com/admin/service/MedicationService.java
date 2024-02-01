package com.admin.service;

import java.util.List;

import com.admin.bean.MedicationBean;
import com.admin.entity.Medication;

public interface MedicationService {
	MedicationBean save(MedicationBean medication);
	MedicationBean getById(long id);
    List<MedicationBean> getAll();
    void delete(long id);
}
