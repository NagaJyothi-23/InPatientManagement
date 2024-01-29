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

import com.admin.entity.BedAllocation;
import com.admin.entity.Medication;
import com.admin.service.BedAllocationService;


@RestController
@RequestMapping(path="bedAllocation")
public class BedAllocationController {

	@Autowired
	BedAllocationService bedAllocationService;
	@PostMapping("/save")
	public ResponseEntity<BedAllocation> save(@RequestBody BedAllocation bedAllocation)
	{
		BedAllocation bedAllocation1=bedAllocationService.save(bedAllocation);
		ResponseEntity<BedAllocation> responseEntity=new ResponseEntity<>(bedAllocation1,HttpStatus.CREATED);
		return responseEntity;
	}
	

	@GetMapping("/getById/{id}")
	public ResponseEntity<BedAllocation> getById(@PathVariable long id) {
		BedAllocation bed=bedAllocationService.getById(id);
		ResponseEntity<BedAllocation> responseEntity = new ResponseEntity<>(bed, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BedAllocation>> getAll() {
		List<BedAllocation> list=bedAllocationService.getAll();
		ResponseEntity<List<BedAllocation>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public  ResponseEntity deleteById(@PathVariable long id)
	{
		bedAllocationService.delete(id);
		ResponseEntity responseEntity=new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping
	public ResponseEntity<BedAllocation> put(@RequestBody BedAllocation bedAllocation) throws Exception {

		BedAllocation bedAllocation1 = bedAllocationService.getById(bedAllocation.getBedNo());
		if (bedAllocation1 != null) {
			bedAllocation1.setRoomtype_id(bedAllocation.getRoomtype_id());
			bedAllocation1.setNo_of_days(bedAllocation.getNo_of_days());
			bedAllocation1.setStart_date(bedAllocation.getStart_date());
			bedAllocation1.setEnd_date(bedAllocation.getEnd_date());
			bedAllocation1.setStatus(bedAllocation.getStatus());


			bedAllocationService.save(bedAllocation1);
		}
		ResponseEntity<BedAllocation> responseEntity = new ResponseEntity<>(bedAllocation1, HttpStatus.OK);
		return responseEntity;
	}
}
