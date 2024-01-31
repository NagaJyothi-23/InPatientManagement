package com.admin.bean;

import com.admin.entity.Ward;

public class RoomTypeBean {
	private long roomType_id;
	private String roomType_name;
	private int roomSharing;
	private double roomPrice;
	private Ward ward_id;
	public RoomTypeBean() {
		super();
	}
	public RoomTypeBean(long roomType_id, String roomType_name, int roomSharing, double roomPrice, Ward ward_id) {
		super();
		this.roomType_id = roomType_id;
		this.roomType_name = roomType_name;
		this.roomSharing = roomSharing;
		this.roomPrice = roomPrice;
		this.ward_id = ward_id;
	}
	@Override
	public String toString() {
		return "RoomTypeBean [roomType_id=" + roomType_id + ", roomType_name=" + roomType_name + ", roomSharing="
				+ roomSharing + ", roomPrice=" + roomPrice + ", ward_id=" + ward_id + "]";
	}
	
}
