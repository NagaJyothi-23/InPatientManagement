package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.admin.service.WardService;

@RestController
@RequestMapping("/ward")

public class WardController {
	@Autowired
	private WardService wardService;

	@PostMapping("/save")
	public ResponseEntity<WardBean> save(@RequestBody WardBean wardBean) {
		System.out.println("coming");
		wardService.save(wardBean);
		ResponseEntity<WardBean> responseEntity = new ResponseEntity<>(wardBean, HttpStatus.CREATED);
		return responseEntity;

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<WardBean> get(@PathVariable Long id) {
		WardBean ward = wardService.getById(id);

		ResponseEntity<WardBean> responseEntity = new ResponseEntity<>(ward, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<WardBean>> getAll() {
		List<WardBean> ward =  wardService.getAll();

		return new ResponseEntity<List<WardBean>>(ward, HttpStatus.OK);

	}
	@PutMapping
	public ResponseEntity<WardBean> put(@RequestBody WardBean wardBean) throws Exception {

		WardBean wardbean1 = wardService.getById(wardBean.getId());
		if (wardbean1 != null) {
			wardbean1.setName(wardBean.getName());
			wardbean1.setCapacity(wardBean.getCapacity());
			wardbean1.setAvailability(wardBean.getAvailability());
			wardbean1.setMedicationId(wardBean.getMedicationId());
			wardService.save(wardBean);

		}
		ResponseEntity<WardBean> responseEntity = new ResponseEntity<>(wardbean1, HttpStatus.OK);
		return responseEntity;
	}


	

	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		wardService.delete(id);
		ResponseEntity<Ward> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

}
