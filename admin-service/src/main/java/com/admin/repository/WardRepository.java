package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.Ward;

@Repository

public interface WardRepository  extends JpaRepository<Ward,Long> {

}
