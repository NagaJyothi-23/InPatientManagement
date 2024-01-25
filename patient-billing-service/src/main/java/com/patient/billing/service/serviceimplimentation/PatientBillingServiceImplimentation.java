package com.patient.billing.service.serviceimplimentation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.billing.service.bean.PatientBillingBean;
import com.patient.billing.service.entity.PatientBillingEntity;
import com.patient.billing.service.exception.BillingIdNotFoundException;
import com.patient.billing.service.exception.PatientBillingExceptionHandler;
import com.patient.billing.service.repository.PatientBillingRepository;
import com.patient.billing.service.service.PatientBillingService;

@Service
public class PatientBillingServiceImplimentation implements PatientBillingService {
	@Autowired
	private PatientBillingRepository patientBillingRepository;

	@Override
	public void save(PatientBillingBean patientBillingBean) {

		PatientBillingEntity patientBillingEntity = new PatientBillingEntity();
		//PatientBillingServiceImplimentation patient=new PatientBillingServiceImplimentation();
		BeanToEntity(patientBillingEntity, patientBillingBean);

		patientBillingRepository.save(patientBillingEntity);

	}
	@Override
	public List<PatientBillingBean> getAll() {
		
		List<PatientBillingBean> patientBillingBean=new ArrayList<>();
		//List<PatientBillingEntity> patiBillingEntity=new ArrayList<>();
	    List<PatientBillingEntity>	patiBillingEntity=patientBillingRepository.findAll();
        entityToBean(patiBillingEntity,patientBillingBean);
		return patientBillingBean;
	}
	@Override
	public Optional<PatientBillingEntity> getById( Integer patientBillingId) {
				
		PatientBillingBean patientBillingBean=new PatientBillingBean();
		Optional<PatientBillingEntity> patientEntity=patientBillingRepository.findById(patientBillingId);
		//entityToBean(patientBillingEntity, patientBillingBean);
		//int billingId=patientEntity.get().getBillId();
		boolean billingId =patientBillingRepository.existsById(patientBillingId);
		if(billingId!=true)
		{
			throw new BillingIdNotFoundException("billing id not found");
		}
		else
		{
			return patientEntity ;
 
		}
	}
	@Override
	public void update(int billingId, String paymentStatus, double paymentAmmount) {
		Optional<PatientBillingEntity> patientBillingEntity=patientBillingRepository.findById(billingId);
		int patientBillingId=patientBillingEntity.get().getBillId();
		//if(patientBillingId.)
		
		
	}
	



	public void BeanToEntity(PatientBillingEntity patientBillingEntity,PatientBillingBean patientBillingBean) {
		//Date currentDate = new Date();
		//LocalDate localDate
		//patientBillingEntity.setBillId(patientBillingBean.getBillId());
		patientBillingEntity.setBillingDate(LocalDate.now());
		patientBillingEntity.setBedAllocationId(patientBillingBean.getBedAllocationId());
		patientBillingEntity.setPaidAmount(patientBillingBean.getPaidAmount());
		patientBillingEntity.setDiscount(patientBillingBean.getDiscount());
		patientBillingEntity.setTotalAmount(patientBillingBean.getTotalAmount());
		patientBillingEntity.setPaymentStatus(patientBillingBean.getPaymentStatus());
	}

	public void entityToBean(List<PatientBillingEntity> patientBillingEntity,List<PatientBillingBean> patientBillingBean)
	{
		
		PatientBillingBean patientbean=new PatientBillingBean();
		for(PatientBillingEntity patientEntity:patientBillingEntity)
		{
			patientbean.setBillId(patientEntity.getBillId());
			patientbean.setBedAllocationId(patientEntity.getBedAllocationId());
			patientbean.setBillingDate(patientEntity.getBillingDate());
			patientbean.setPaidAmount(patientEntity.getPaidAmount());
			patientbean.setDiscount(patientEntity.getDiscount());
			patientbean.setPaymentStatus(patientEntity.getPaymentStatus());
			patientBillingBean.add(patientbean);
			
		}
	}
		
		public void entityToBean(PatientBillingEntity patientBillingEntity,PatientBillingBean patientBillingBean)
		{
			
			PatientBillingBean patientbean=new PatientBillingBean();
			
				patientbean.setBillId(patientBillingEntity.getBillId());
				patientbean.setBedAllocationId(patientBillingEntity.getBedAllocationId());
				patientbean.setBillingDate(patientBillingEntity.getBillingDate());
				patientbean.setPaidAmount(patientBillingEntity.getPaidAmount());
				patientbean.setDiscount(patientBillingEntity.getDiscount());
				patientbean.setPaymentStatus(patientBillingEntity.getPaymentStatus());
				
				
			
	}
		
}
