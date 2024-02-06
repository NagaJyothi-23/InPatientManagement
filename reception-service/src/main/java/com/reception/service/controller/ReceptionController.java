package com.reception.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.reception.service.bean.BedAllocationBean;
import com.reception.service.bean.BillingBean;
import com.reception.service.bean.PatitentBean;
import com.reception.service.exception.BedDetailsNotFoundException;
import com.reception.service.exception.BillingDetailsNotFoundException;
import com.reception.service.exception.PatitentDetailsNotFoundException;
import com.reception.service.service.ReceptionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReceptionController {
	private static Logger log = LoggerFactory.getLogger(ReceptionController.class.getSimpleName());

	@Autowired
	private ReceptionService receptionService;

	@GetMapping(path = "details/{id}")
	public ResponseEntity<PatitentBean> getPatientDetails(@PathVariable(value = "id") int patitentId) {
		try {
			log.info("Patitent details{}" + patitentId);
			PatitentBean patitentBean = receptionService.patitentDetails(patitentId);

			return new ResponseEntity<PatitentBean>(patitentBean, HttpStatus.OK);
		} catch (PatitentDetailsNotFoundException e) {
			System.out.println(e.getMessage());
			log.info("Patitent details end{}" + patitentId);
			return new ResponseEntity<PatitentBean>(HttpStatus.NOT_FOUND);

		}

	}
	
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<PatitentBean>> PatientDetails() {
		try {
			log.info("Patitent details{}" );
			List<PatitentBean> patitentBean = receptionService.getPatitentDetails();

			return new ResponseEntity<List<PatitentBean>>(patitentBean, HttpStatus.OK);
		} catch (PatitentDetailsNotFoundException e) {
			System.out.println(e.getMessage());
			log.info("Patitent details end{}" );
			return new ResponseEntity<List<PatitentBean>>(HttpStatus.NOT_FOUND);

		}

	}
	

	@GetMapping(path = "billingdetails/{id}")
	public ResponseEntity<BillingBean> getBillingDetails(@PathVariable(value = "id") int billingId) {
		try {
			log.info("billing details{}" + billingId);
			BillingBean billingBean = receptionService.billingDetails(billingId);

			return new ResponseEntity<BillingBean>(billingBean, HttpStatus.OK);
		} catch (BillingDetailsNotFoundException e) {
			System.out.println(e.getMessage());
			log.info("billing  end details{}" + billingId);
			return new ResponseEntity<BillingBean>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "beddetails/{id}")
	public ResponseEntity<BedAllocationBean> details(@PathVariable(value = "id") Integer bedId) {
		System.out.println("controller");
		try {
			log.info("bed details{}" + bedId);
			BedAllocationBean patientBillingBean = receptionService.bedAllocationDetails(bedId);
			return new ResponseEntity<BedAllocationBean>(patientBillingBean, HttpStatus.OK);
		} catch (BedDetailsNotFoundException e) {
			System.out.println(e.getMessage());
			log.info("bed details end{}" + bedId);
			return new ResponseEntity<BedAllocationBean>(HttpStatus.NOT_FOUND);

		}
	}
	@GetMapping(path ="/getbeds")
	public ResponseEntity<List<BedAllocationBean>> getBedAllocationDetails() {
		try {
			log.info("Patitent details{}" );
			List<BedAllocationBean> bedAllocationBean = receptionService.getBedAllocationDetails();

			return new ResponseEntity<List<BedAllocationBean>>(bedAllocationBean, HttpStatus.OK);
		} catch (BedDetailsNotFoundException e) {
			System.out.println(e.getMessage());
			log.info("bedAllocation details end{}" );
			return new ResponseEntity<List<BedAllocationBean>>(HttpStatus.NOT_FOUND);

		}

	}


}
