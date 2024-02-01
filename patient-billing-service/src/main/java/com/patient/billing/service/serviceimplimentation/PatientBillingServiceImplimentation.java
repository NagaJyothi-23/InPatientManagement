package com.patient.billing.service.serviceimplimentation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.patient.billing.service.bean.BedAllocationBean;
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
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public BedAllocationBean getDetails(int bedId) {
		String url = "http://localhost:8080/bedAllocation/getById/1";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<BedAllocationBean> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				BedAllocationBean.class);
		
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
	        // Retrieve the response body containing the BedAllocationBean
	        BedAllocationBean bedAllocation = responseEntity.getBody();

	        // Check for null before returning
	        if (bedAllocation != null) {
	            return bedAllocation;
	        } else {
	            // Handle the case where the response body is null
	            // You can throw an exception, log a message, or return a default value
	            // For example, throw new RuntimeException("Received null response for bedId: " + bedId);
	        }
	    }
		else {
	    	System.out.println("exception occured");
	    	return null;
	        // Handle non-successful HTTP status codes if needed
	        // For example, log an error message or throw an exception
	        // throw new RuntimeException("Failed to retrieve data. Status code: " + responseEntity.getStatusCodeValue());
	    }
		//BedAllocationBean bedAllocation = responseEntity.getBody();		
		
		//return bedAllocation;
		return null;
	}
	

	@Override
	public void save(PatientBillingBean patientBillingBean) {

		PatientBillingEntity patientBillingEntity = new PatientBillingEntity();
		BeanToEntity(patientBillingEntity, patientBillingBean);

		patientBillingRepository.save(patientBillingEntity);

	}

	@Override
	public List<PatientBillingBean> getAll() {

		List<PatientBillingBean> patientBillingBean = new ArrayList<>();
		List<PatientBillingEntity> patiBillingEntity = patientBillingRepository.findAll();
		entityToBean(patiBillingEntity, patientBillingBean);
		return patientBillingBean;
	}

	@Override
	public PatientBillingBean getById(Integer patientBillingId) {

		PatientBillingBean patientBillingBean = new PatientBillingBean();
		if(patientBillingRepository.existsById(patientBillingId)) {
			Optional<PatientBillingEntity> patientEntity = patientBillingRepository.findById(patientBillingId);
		    entityToBean(patientEntity.get(), patientBillingBean);
		}
		
		else {
			throw new BillingIdNotFoundException("billing id not found");
		}
		return patientBillingBean;
	}

	@Override
	public PatientBillingEntity update(Integer billingId, Double paymentAmmount) {
		Optional<PatientBillingEntity> patientBillingEntity = patientBillingRepository.findById(billingId);
		if (patientBillingEntity.isEmpty()) {
			System.out.println(patientBillingEntity);
			throw new BillingIdNotFoundException("billing id not found");
		}

		else {
			PatientBillingEntity patientEntity = patientBillingEntity.get();

			int patientBillingId = patientBillingEntity.get().getBillId();
				double totalAmount = patientBillingEntity.get().getTotalAmount();
				double paidAmount = patientBillingEntity.get().getPaidAmount();
				double totalPaidAmount = paidAmount + paymentAmmount;
				if (totalPaidAmount == totalAmount) {
					patientBillingEntity.get().setPaymentStatus("Completed");
					patientBillingRepository.save(patientEntity);

				} else {
					patientBillingEntity.get().setPaymentStatus("pending");
					// throw new BillingIdNotFoundException("Billing Id not found") ;

				}
			return patientEntity;

		}

	}

	public void BeanToEntity(PatientBillingEntity patientBillingEntity, PatientBillingBean patientBillingBean) {
		// Date currentDate = new Date();
		// LocalDate localDate
		// patientBillingEntity.setBillId(patientBillingBean.getBillId());
		patientBillingEntity.setBillingDate(LocalDate.now());
		patientBillingEntity.setBedAllocationId(patientBillingBean.getBedAllocationId());
		patientBillingEntity.setPaidAmount(patientBillingBean.getPaidAmount());
		patientBillingEntity.setDiscount(patientBillingBean.getDiscount());
		patientBillingEntity.setTotalAmount(patientBillingBean.getTotalAmount());
		patientBillingEntity.setPaymentStatus(patientBillingBean.getPaymentStatus());
	}

	public void entityToBean(List<PatientBillingEntity> patientBillingEntity,
			List<PatientBillingBean> patientBillingBean) {

		PatientBillingBean patientbean = new PatientBillingBean();
		for (PatientBillingEntity patientEntity : patientBillingEntity) {
			patientbean.setBillId(patientEntity.getBillId());
			 patientbean.setBedAllocationId(patientEntity.getBedAllocationId());
			patientbean.setBillingDate(patientEntity.getBillingDate());
			patientbean.setPaidAmount(patientEntity.getPaidAmount());
			patientbean.setDiscount(patientEntity.getDiscount());
			patientbean.setTotalAmount(patientEntity.getTotalAmount());
			patientbean.setPaymentStatus(patientEntity.getPaymentStatus());
			patientBillingBean.add(patientbean);

		}
	}

	public void entityToBean(PatientBillingEntity patientBillingEntity, PatientBillingBean patientBillingBean) {

		//PatientBillingBean patientbean = new PatientBillingBean();

		patientBillingBean.setBillId(patientBillingEntity.getBillId());
		patientBillingBean.setBedAllocationId(patientBillingEntity.getBedAllocationId());
		patientBillingBean.setBillingDate(patientBillingEntity.getBillingDate());
		patientBillingBean.setPaidAmount(patientBillingEntity.getPaidAmount());
		patientBillingBean.setDiscount(patientBillingEntity.getDiscount());
		patientBillingBean.setPaymentStatus(patientBillingEntity.getPaymentStatus());
		patientBillingBean.setTotalAmount(patientBillingEntity.getTotalAmount());

	}

}
