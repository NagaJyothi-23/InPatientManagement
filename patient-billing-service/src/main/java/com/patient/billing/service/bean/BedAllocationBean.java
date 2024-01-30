package com.patient.billing.service.bean;

import java.sql.Date;

public class BedAllocationBean {
	
	private int bedNo;
	private long patient_id;
	private long ward_id;
	private int no_of_days;
	private long roomtype_id;
	private Date start_date;
	private Date end_date;
	private String status;
	public long getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public long getWard_id() {
		return ward_id;
	}
	public void setWard_id(long ward_id) {
		this.ward_id = ward_id;
	}
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}
	public long getRoomtype_id() {
		return roomtype_id;
	}
	public void setRoomtype_id(long roomtype_id) {
		this.roomtype_id = roomtype_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BedAllocationBean(int bedNo, long patient_id, long ward_id, int no_of_days, long roomtype_id,
			Date start_date, Date end_date, String status) {
		super();
		this.bedNo = bedNo;
		this.patient_id = patient_id;
		this.ward_id = ward_id;
		this.no_of_days = no_of_days;
		this.roomtype_id = roomtype_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}
	public BedAllocationBean() {
	}

}
