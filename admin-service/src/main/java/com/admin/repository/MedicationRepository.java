package com.admin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.bean.MedicationBean;
import com.admin.entity.Medication;



@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long>{
	
}
