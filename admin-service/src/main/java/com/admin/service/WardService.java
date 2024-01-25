package com.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.entity.*;


public interface WardService {
	void save(Ward ward);

	Ward get(int id);

	void delete(int id);

	List<Ward> getAll();

}
