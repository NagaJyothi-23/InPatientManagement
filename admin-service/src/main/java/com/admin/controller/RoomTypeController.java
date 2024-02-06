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
import com.admin.entity.RoomTypeEntity;
import com.admin.exception.RecordNotFoundException;
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
	public ResponseEntity<RoomTypeBean> save(@RequestBody RoomTypeBean roomTypeBean) {
		try {
			roomTypeService.save(roomTypeBean);
			ResponseEntity<RoomTypeBean> entity = new ResponseEntity<>(roomTypeBean, HttpStatus.CREATED);
			System.out.println("inserted");
			return entity;
		} catch (Exception e) {
			return new ResponseEntity<RoomTypeBean>(HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<RoomTypeBean>> getAll() {
		try {
		List<RoomTypeBean> list = roomTypeService.getAll();
		return new ResponseEntity<List<RoomTypeBean>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<RoomTypeBean> getById(@PathVariable Long id) {
		try {
			RoomTypeBean roombyid = roomTypeService.getById(id);
			return new ResponseEntity<RoomTypeBean>(roombyid, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RoomTypeBean>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
		roomTypeService.delete(id);
		return new ResponseEntity<String>("deleted successfully"+id,HttpStatus.OK);
		}catch(RecordNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage()+id,HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/update")
	public ResponseEntity<String> put(@RequestBody RoomTypeBean roomTypeBean,@PathVariable Long id){

//		RoomTypeBean roomBean = roomTypeService.getById(roomTypeBean.getId());
//		if (roomBean != null) {
//			roomBean.setRoomSharing(roomTypeBean.getRoomSharing());
//			roomBean.setRoomPrice(roomTypeBean.getRoomPrice());
//			roomBean.setName(roomTypeBean.getName());
//			roomBean.setWardId(roomTypeBean.getWardId());
//			roomTypeService.save(roomBean);
//		}
//		ResponseEntity<RoomTypeBean> responseEntity = new ResponseEntity<>(roomBean, HttpStatus.OK);
//		return responseEntity;
		try {
			roomTypeService.update(id,roomTypeBean);
			return new ResponseEntity<>("Update successfully" + roomTypeBean , HttpStatus.OK);
		}catch(RecordNotFoundException e) {
			return new ResponseEntity<>(e.getMessage() +roomTypeBean, HttpStatus.NOT_FOUND);

		}

	}
}
