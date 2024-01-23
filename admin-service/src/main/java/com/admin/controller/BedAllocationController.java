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
	
	@PutMapping("/update")
	public  ResponseEntity deleteById(@RequestBody BedAllocation bedAllocation)
	{
		bedAllocationService.update(bedAllocation);
		ResponseEntity responseEntity=new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
}
