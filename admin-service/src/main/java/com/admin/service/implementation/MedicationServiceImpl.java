package com.admin.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.bean.MedicationBean;
import com.admin.entity.Medication;
import com.admin.exception.RecordNotFoundException;
import com.admin.repository.MedicationRepository;
import com.admin.service.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService{

	@Autowired
	MedicationRepository medicationRepository;
	@Override
	public MedicationBean save(MedicationBean medicationBean) {
		// TODO Auto-generated method stub
		Medication medication=new Medication();
		beanToEntity(medicationBean,medication);
		 medicationRepository.save(medication);
		 return medicationBean;
	}
	@Override
	public MedicationBean getById(long id) {
		// TODO Auto-generated method stub
		Medication medication= medicationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
		MedicationBean medicationBean=new MedicationBean();
		entityToBean(medication,medicationBean);
		return medicationBean;
	}
	@Override
	public List<MedicationBean> getAll() {
		// TODO Auto-generated method stub
		 List<Medication> list=medicationRepository.findAll();
		 List<MedicationBean> beanList=new ArrayList<MedicationBean>();
		 entityToBean(list,beanList);
		 return beanList;
		
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		medicationRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Record Found with given id"));
	    medicationRepository.deleteById(id);
	
	}

	public void beanToEntity(MedicationBean medicationBean,Medication medication)
	{
		medication.setId(medicationBean.getId());
		medication.setMedicationName(medicationBean.getMedicationName());
		
	}

	public void entityToBean(Medication medication,MedicationBean medicationBean)
	{
		medicationBean.setId(medication.getId());
		medicationBean.setMedicationName(medication.getMedicationName());
	}
	
	public void entityToBean(List<Medication> list,List<MedicationBean> beanList)
	{
		
		for(Medication medication:list)
		{
			MedicationBean medicationBean=new MedicationBean();
			medicationBean.setId(medication.getId());
			medicationBean.setMedicationName(medication.getMedicationName());
			beanList.add(medicationBean);
		}

		
		
	}
}
