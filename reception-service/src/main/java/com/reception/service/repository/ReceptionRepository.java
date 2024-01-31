package com.reception.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reception.service.bean.PatitentBean;

public interface ReceptionRepository extends JpaRepository<PatitentBean, Integer>
{
	

}
