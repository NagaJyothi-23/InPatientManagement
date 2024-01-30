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
	public ResponseEntity<BedAllocation> getById(@PathVariable int id) {
		BedAllocation bed=bedAllocationService.getById(id);
//		ResponseEntity<BedAllocation> responseEntity = new ResponseEntity<>(bed, HttpStatus.OK);
//		return responseEntity;
		return new ResponseEntity<BedAllocation>(bed,HttpStatus.OK) ;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BedAllocation>> getAll() {
		List<BedAllocation> list=bedAllocationService.getAll();
		ResponseEntity<List<BedAllocation>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public  ResponseEntity deleteById(@PathVariable int id)
	{
		bedAllocationService.delete(id);
		ResponseEntity responseEntity=new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping
	public ResponseEntity<BedAllocation> put(@RequestBody BedAllocation bedAllocation) throws Exception {

		BedAllocation bedAllocation1 = bedAllocationService.getById(bedAllocation.getBedAllocationId());
		if (bedAllocation1 != null) {
			bedAllocation1.setRoomtypeId(bedAllocation.getRoomtypeId());
			bedAllocation1.setBedAllocationId(bedAllocation.getBedAllocationId());
			bedAllocation1.setStartDate(bedAllocation.getStartDate());
			bedAllocation1.setEndDate(bedAllocation.getEndDate());
			bedAllocation1.setStatus(bedAllocation.getStatus());


			bedAllocationService.save(bedAllocation1);
		}
		ResponseEntity<BedAllocation> responseEntity = new ResponseEntity<>(bedAllocation1, HttpStatus.OK);
		return responseEntity;
	}
}
