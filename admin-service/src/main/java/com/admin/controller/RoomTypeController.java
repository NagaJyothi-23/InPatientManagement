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

import com.admin.bean.RoomTypeBean;
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
	public ResponseEntity<RoomTypeBean> save(@RequestBody RoomTypeBean roomTypeBean){
		roomTypeService.save(roomTypeBean);
		ResponseEntity<RoomTypeBean> entity=new ResponseEntity<>(roomTypeBean,HttpStatus.CREATED);
		System.out.println("inserted");
		return entity;
		
		
	}
	@GetMapping(path ="/getAll")
	public ResponseEntity<List<RoomTypeBean>> getAll(){
		List<RoomTypeBean> list=roomTypeService.getAll();
		return new ResponseEntity<List<RoomTypeBean>>(list,HttpStatus.OK);
	}
	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<RoomTypeBean> getById(@PathVariable Long id){
		RoomTypeBean roombyid = roomTypeService.getById(id);
		return new ResponseEntity<RoomTypeBean>(roombyid,HttpStatus.OK);	
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<RoomTypeEntity> delete(@PathVariable Long id){
		roomTypeService.delete(id);
		return new ResponseEntity<RoomTypeEntity>(HttpStatus.OK);
		
	}
@PutMapping(path = "/update")
public ResponseEntity<RoomTypeBean> put(@RequestBody RoomTypeBean roomTypeBean) throws Exception {

	RoomTypeBean roomBean= roomTypeService.getById(roomTypeBean.getId());
	if (roomBean != null) {
		roomBean.setRoomSharing(roomTypeBean.getRoomSharing());
		roomBean.setRoomPrice(roomTypeBean.getRoomPrice());
		roomBean.setName(roomTypeBean.getName());
		roomBean.setWardId(roomTypeBean.getWardId());

		roomTypeService.save(roomBean);
	}
	ResponseEntity<RoomTypeBean> responseEntity = new ResponseEntity<>(roomBean, HttpStatus.OK);
	return responseEntity;
}
}
