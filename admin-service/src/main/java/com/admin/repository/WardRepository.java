package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.bean.WardBean;
import com.admin.entity.Medication;
import com.admin.entity.Ward;

@Repository

public interface WardRepository  extends JpaRepository<Ward,Long> {
	List<Ward> findByMedicationId_Id(Long medicationId);
}
