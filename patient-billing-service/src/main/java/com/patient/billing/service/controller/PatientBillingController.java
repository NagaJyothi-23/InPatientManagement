package com.patient.billing.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.patient.billing.service.bean.PatientBillingBean;
import com.patient.billing.service.entity.PatientBillingEntity;
import com.patient.billing.service.service.PatientBillingService;

@RestController
public class PatientBillingController 
{
	@Autowired
	   private PatientBillingService patientBillingService;
	   
	   @PostMapping(path="/save")
	   public ResponseEntity<PatientBillingBean>save(@RequestBody PatientBillingBean patientBillingBean)
	   {
		   System.out.println("controller");
		   patientBillingService.save(patientBillingBean);
		   return new ResponseEntity<PatientBillingBean>(patientBillingBean,HttpStatus.OK) ;
	   }
	   
	   @GetMapping(path="/getAll")
	   public ResponseEntity<List<PatientBillingBean>> getAll()
	   {
		   System.out.println("controller");
		   List<PatientBillingBean> patientBillingBean=patientBillingService.getAll();
		   return new ResponseEntity<List<PatientBillingBean>>(patientBillingBean,HttpStatus.OK) ;
	   }
	   @GetMapping(path="fetch/{id}")
	   public ResponseEntity<PatientBillingEntity> getById(@PathVariable(value = "id") Integer billingId)
	   {
		   Optional<PatientBillingEntity> patientBillingEntity=patientBillingService.getById(billingId);
		   return new ResponseEntity<PatientBillingEntity>(patientBillingEntity.get(),HttpStatus.OK) ;
	   }
	   

}
