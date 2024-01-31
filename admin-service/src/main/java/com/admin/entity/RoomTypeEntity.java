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
	@Column(name = "roomTypeId")
	private long id;
	@Column(name = "roomTypeName")
	private String name;
	@Column(name = "roomSharing")
	private int roomSharing;
	@Column(name = "roomPrice")
	private double roomPrice;
	@ManyToOne
	@JoinColumn(name = "wardId", referencedColumnName = "wardId")
	private Ward wardId;

	public long getId() {
		return id;
	}

	public RoomTypeEntity() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Ward getWardId() {
		return wardId;
	}

	public void setWardId(Ward wardId) {
		this.wardId = wardId;
	}

	public RoomTypeEntity(long id, String name, int roomSharing, double roomPrice, Ward wardId) {
		super();
		this.id = id;
		this.name = name;
		this.roomSharing = roomSharing;
		this.roomPrice = roomPrice;
		this.wardId = wardId;
	}

	@Override
	public String toString() {
		return "RoomTypeEntity [id=" + id + ", name=" + name + ", roomSharing=" + roomSharing + ", roomPrice="
				+ roomPrice + ", wardId=" + wardId + "]";
	}

}
