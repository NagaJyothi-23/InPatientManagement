package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.bean.WardBean;
import com.admin.entity.Ward;
import com.admin.exception.ControllerExceptionHandler;
import com.admin.exception.RecordNotFoundException;
import com.admin.service.WardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/ward")

public class WardController {
	Logger log = LoggerFactory.getLogger(WardController.class);

	@Autowired
	private WardService wardService;

	@PostMapping("/save")
	public ResponseEntity<WardBean> save(@RequestBody WardBean wardBean) {
		log.info("started WardController ::save()");
		try {
			wardService.save(wardBean);
			return new ResponseEntity<WardBean>(HttpStatus.OK);

		} catch (Exception e) {
			log.error("exception handled");
			return new ResponseEntity<WardBean>(HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<WardBean> get(@PathVariable Long id) {
		log.info("start wardController:getById");

		try {
			WardBean wardBean = wardService.getById(id);
			return new ResponseEntity<WardBean>(HttpStatus.OK);

		} catch (Exception e) {
			log.error("exception started");
			return new ResponseEntity<WardBean>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<WardBean>> getAll() {
		try {
			List<WardBean> wardBean = wardService.getAll();

			return new ResponseEntity<List<WardBean>>(wardBean, HttpStatus.OK);

		} catch (Exception e) {
			log.error("exception started");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> put(@RequestBody WardBean wardBean, @PathVariable Long id) {

//		WardBean wardbean1 = wardService.getById(wardBean.getId());
//		if (wardbean1 != null) {
//			wardbean1.setName(wardBean.getName());
//			wardbean1.setCapacity(wardBean.getCapacity());
//			wardbean1.setAvailability(wardBean.getAvailability());
//			wardbean1.setMedicationId(wardBean.getMedicationId());
//			wardService.save(wardBean);
//
//		}

		log.info("start::wardController:update");

		try {
			wardService.update(wardBean);
			return new ResponseEntity<>("Update successfully" + wardBean, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			log.error("exception started");
			return new ResponseEntity<>(e.getMessage() + wardBean, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		log.info("Start WardController:delete()");
		try {
			wardService.delete(id);
			return new ResponseEntity<String>("deleted successfully" + id, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			log.error("exception handled");

			return new ResponseEntity<String>(e.getMessage() + id, HttpStatus.NOT_FOUND);
		}

	}

}