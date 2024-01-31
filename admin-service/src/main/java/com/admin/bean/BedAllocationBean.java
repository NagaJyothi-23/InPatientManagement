package com.admin.bean;

import java.sql.Date;


import com.admin.entity.RoomTypeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BedAllocationBean {

	private int id;
	private int patientId;
	private int noOfDays;
	private RoomTypeEntity roomtypeId;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public BedAllocationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BedAllocationBean(int id, int patientId, int noOfDays, RoomTypeEntity roomtypeId, Date startDate,
			Date endDate, String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.noOfDays = noOfDays;
		this.roomtypeId = roomtypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public RoomTypeEntity getRoomtypeId() {
		return roomtypeId;
	}

	public void setRoomtypeId(RoomTypeEntity roomtypeId) {
		this.roomtypeId = roomtypeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BedAllocationBean [id=" + id + ", patientId=" + patientId + ", noOfDays=" + noOfDays + ", roomtypeId="
				+ roomtypeId + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}

}
	
	

	


