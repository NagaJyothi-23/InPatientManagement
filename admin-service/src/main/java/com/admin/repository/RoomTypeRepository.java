package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.RoomTypeEntity;
@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity,Long>{


}
