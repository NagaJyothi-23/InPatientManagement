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

import com.admin.entity.Medication;
import com.admin.entity.RoomTypeEntity;
import com.admin.repository.RoomTypeRepository;
import com.admin.service.RoomTypeService;
@RestController
@RequestMapping("/room")
public class RoomTypeController {
	@Autowired
	RoomTypeService roomTypeService;
	@Autowired
	RoomTypeRepository roomTypeRepository;
	@PostMapping(path = "/save")
	public ResponseEntity<RoomTypeEntity> insert(@RequestBody RoomTypeEntity roomType){
		roomTypeService.save(roomType);
		ResponseEntity<RoomTypeEntity> entity=new ResponseEntity<>(roomType,HttpStatus.CREATED);
		System.out.println("inserted");
		return entity;
	}
	@GetMapping(path ="/getAll")
	public ResponseEntity<List<RoomTypeEntity>> getAll(){
		List<RoomTypeEntity> list=roomTypeService.getAll();
		return new ResponseEntity<List<RoomTypeEntity>>(list,HttpStatus.OK);
	}
	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<RoomTypeEntity> getById(@PathVariable Long id){
		RoomTypeEntity roombyid = roomTypeService.getById(id);
		return new ResponseEntity<RoomTypeEntity>(roombyid,HttpStatus.OK);	
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<RoomTypeEntity> delete(@PathVariable Long id){
		roomTypeService.delete(id);
		return new ResponseEntity<RoomTypeEntity>(HttpStatus.OK);
		
	}
//	@PutMapping(path = "/update")
//	public ResponseEntity<RoomType> update(@PathVariable Long id){
//		RoomroomTypeService.update(id);
//	}
@PutMapping
public ResponseEntity<RoomTypeEntity> put(@RequestBody RoomTypeEntity roomTypeEntity) throws Exception {

	RoomTypeEntity roomTypeEntity1 = roomTypeService.getById(roomTypeEntity.getRoomType_id());
	if ( roomTypeEntity1!= null) {
		roomTypeEntity1.setRoomSharing(roomTypeEntity.getRoomSharing());
		roomTypeEntity1.setRoomPrice(roomTypeEntity.getRoomPrice());
		roomTypeEntity1.setRoomType_name(roomTypeEntity.getRoomType_name());


		roomTypeService.save(roomTypeEntity1);
	}
	ResponseEntity<RoomTypeEntity> responseEntity = new ResponseEntity<>(roomTypeEntity1, HttpStatus.OK);
	return responseEntity;
}
}
