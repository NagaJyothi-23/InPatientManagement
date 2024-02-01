package com.admin.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bedAllocation")
public class BedAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bed_allocation_id")
	private int id;
	@Column(name = "patient_id")
	private int patientId;
	@Column(name = "no_of_days")
	private int noOfDays;
	@ManyToOne
	@JoinColumn(name = "roomtype_id", referencedColumnName = "roomTypeId")
	private RoomTypeEntity roomTypeId;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "status")
	private String status;

	public BedAllocation() {

	}

	public BedAllocation(int id, int patientId, int noOfDays, RoomTypeEntity roomTypeId, Date startDate, Date endDate,
			String status) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.noOfDays = noOfDays;
		this.roomTypeId = roomTypeId;
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

	public RoomTypeEntity getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(RoomTypeEntity roomTypeId) {
		this.roomTypeId = roomTypeId;
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
		return "BedAllocation [id=" + id + ", patientId=" + patientId + ", noOfDays=" + noOfDays + ", roomTypeId="
				+ roomTypeId + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}

}
