package com.admin.service;

import java.util.List;

import com.admin.entity.Medication;

public interface MedicationService {
    Medication save(Medication medication);
    Medication getById(long id);
    List<Medication> getAll();
    void delete(long id);
}
