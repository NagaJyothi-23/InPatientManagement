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

import com.admin.bean.BedAllocationBean;
import com.admin.entity.BedAllocation;
import com.admin.service.BedAllocationService;

@RestController
@RequestMapping(path = "bedAllocation")
public class BedAllocationController {

	@Autowired
	BedAllocationService bedAllocationService;

	@PostMapping("/save")
	public ResponseEntity<BedAllocationBean> save(@RequestBody BedAllocationBean bedAllocationBean) {
		BedAllocationBean bedAllocation1 = bedAllocationService.save(bedAllocationBean);
		ResponseEntity<BedAllocationBean> responseEntity = new ResponseEntity<>(bedAllocation1, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<BedAllocationBean> getById(@PathVariable int id) {
		BedAllocationBean bedAllocation = bedAllocationService.getById(id);
//		ResponseEntity<BedAllocation> responseEntity = new ResponseEntity<>(bed, HttpStatus.OK);
//		return responseEntity;
		return new ResponseEntity<BedAllocationBean>(bedAllocation, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BedAllocationBean>> getAll() {
		List<BedAllocationBean> list = bedAllocationService.getAll();
		ResponseEntity<List<BedAllocationBean>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable int id) {
		bedAllocationService.delete(id);
		ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping
	public ResponseEntity<BedAllocationBean> put(@RequestBody BedAllocationBean bedAllocationBean) throws Exception {

		BedAllocationBean bedAllocation1 = bedAllocationService.getById(bedAllocationBean.getId());
		if (bedAllocation1 != null) {
			
			bedAllocation1.setId(bedAllocationBean.getId());
			bedAllocation1.setStartDate(bedAllocationBean.getStartDate());
			bedAllocation1.setEndDate(bedAllocationBean.getEndDate());
			bedAllocation1.setStatus(bedAllocationBean.getStatus());
			bedAllocation1.setRoomTypeId(bedAllocationBean.getRoomTypeId());
			bedAllocationService.save(bedAllocation1);
		}
		ResponseEntity<BedAllocationBean> responseEntity = new ResponseEntity<>(bedAllocation1, HttpStatus.OK);
		return responseEntity;
	}
}
