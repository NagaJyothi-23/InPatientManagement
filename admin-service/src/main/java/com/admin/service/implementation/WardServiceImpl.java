package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.MedicationBean;
import com.admin.bean.WardBean;
import com.admin.entity.Medication;
import com.admin.entity.Ward;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.WardRepository;
import com.admin.service.WardService;

@Service
public class WardServiceImpl implements WardService {
	@Autowired
	private WardRepository wardRepository;

	@Override
	public void save(WardBean wardBean) {

		Ward ward = new Ward();
		BeanToEntity(ward, wardBean);

		wardRepository.save(ward);

	}

	private void BeanToEntity(Ward ward, WardBean wardBean) {
		ward.setId(wardBean.getId());
		ward.setName(wardBean.getName());
		ward.setCapacity(wardBean.getCapacity());
		ward.setAvailability(wardBean.getAvailability());
		MedicationBean medicationBean = wardBean.getMedicationId();
		Medication medication = new Medication();
		beanToEntity(medicationBean, medication);
		ward.setMedicationId(medication);

	}

	private void entityToBean(WardBean wardBean, Ward ward) {
		wardBean.setId(ward.getId());
		wardBean.setName(ward.getName());
		wardBean.setCapacity(ward.getCapacity());
		wardBean.setAvailability(ward.getAvailability());
		MedicationBean medicationBean = new MedicationBean();
		Medication medication = ward.getMedicationId();
		entityToBean(medication, medicationBean);
		wardBean.setMedicationId(medicationBean);

	}

	public WardBean getById(Long id) {
		WardBean wardBean = new WardBean();

		Ward ward = wardRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
		entityToBean(wardBean, ward);

		return wardBean;
	}

	@Override
	public void delete(Long id) {
		wardRepository.deleteById(id);

	}

	@Override
	public List<WardBean> getAll() {
		List<Ward> entityList = wardRepository.findAll();
		List<WardBean> beanList = new ArrayList<>();
		entityToBean(entityList, beanList);
		return beanList;
	}

	private void entityToBean(List<Ward> entityList, List<WardBean> beanList) {
		for (Ward ward : entityList) {
			WardBean wardBean = new WardBean();
			wardBean.setId(ward.getId());
			wardBean.setName(ward.getName());
			wardBean.setCapacity(ward.getCapacity());
			wardBean.setAvailability(ward.getAvailability());
			MedicationBean medicationBean = new MedicationBean();
			Medication medication = ward.getMedicationId();
			entityToBean(medication, medicationBean);
			wardBean.setMedicationId(medicationBean);
			beanList.add(wardBean);
		}

	}

	@Override
	public void update(WardBean wardBean) {
		Ward ward = wardRepository.getReferenceById(wardBean.getId());
		ward.setId(wardBean.getId());
		ward.setName(wardBean.getName());
		ward.setCapacity(wardBean.getCapacity());
		ward.setAvailability(wardBean.getAvailability());
		Medication medication = ward.getMedicationId();
		
		ward.setMedicationId(medication);
		wardRepository.save(ward);


	}

	public void beanToEntity(MedicationBean medicationBean, Medication medication) {
		medication.setId(medicationBean.getId());
		medication.setMedicationName(medicationBean.getMedicationName());

	}

	public void entityToBean(Medication medication, MedicationBean medicationBean) {
		medicationBean.setId(medication.getId());
		medicationBean.setMedicationName(medication.getMedicationName());
	}

}
