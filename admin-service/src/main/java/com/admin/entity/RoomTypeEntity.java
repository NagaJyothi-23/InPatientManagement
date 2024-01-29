package com.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roomType")
public class RoomTypeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomType_id")
	private long roomType_id;
	@Column(name = "roomType_name")
	private String roomType_name;
	@Column(name = "roomSharing")
	private int roomSharing;
	@Column(name = "roomPrice")
	private double roomPrice;
	@ManyToOne
	@JoinColumn(name = "ward_id",referencedColumnName = "ward_id")
	private Ward ward_id;
	public long getRoomType_id() {
		return roomType_id;
	}
	public void setRoomType_id(long roomType_id) {
		this.roomType_id = roomType_id;
	}
	public String getRoomType_name() {
		return roomType_name;
	}
	public void setRoomType_name(String roomType_name) {
		this.roomType_name = roomType_name;
	}
	public int getRoomSharing() {
		return roomSharing;
	}
	public void setRoomSharing(int roomSharing) {
		this.roomSharing = roomSharing;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Ward getWard_id() {
		return ward_id;
	}
	public void setWard_id(Ward ward_id) {
		this.ward_id = ward_id;
	}
	public RoomTypeEntity(long roomType_id, String roomType_name, int roomSharing, double roomPrice, Ward ward_id) {
		super();
		this.roomType_id = roomType_id;
		this.roomType_name = roomType_name;
		this.roomSharing = roomSharing;
		this.roomPrice = roomPrice;
		this.ward_id = ward_id;
	}
	public RoomTypeEntity() {
		super();
	}
	@Override
	public String toString() {
		return "RoomTypeEntity [roomType_id=" + roomType_id + ", roomType_name=" + roomType_name + ", roomSharing="
				+ roomSharing + ", roomPrice=" + roomPrice + ", ward_id=" + ward_id + "]";
	}
	
	
}
