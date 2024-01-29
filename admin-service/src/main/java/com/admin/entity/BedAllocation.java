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
@Table(name="bedAllocation")
public class BedAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bedNo")
	private long bedNo;
	@Column(name="patient_id")
	private long patient_id;
	@Column(name="no_of_days")
	private int no_of_days;
	@ManyToOne
	@JoinColumn(name="roomtype_id",referencedColumnName = "roomType_id")
	private RoomTypeEntity roomtype_id;
	@Column(name="start_date")
	private Date start_date;
	@Column(name="end_date")
	private Date end_date;
	@Column(name="status")
	private String status;
	
	public BedAllocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BedAllocation(long bedNo, long patient_id, int no_of_days,RoomTypeEntity  roomtype_id, Date start_date,
			Date end_date, String status) {
		super();
		this.bedNo = bedNo;
		this.patient_id = patient_id;
		this.no_of_days = no_of_days;
		this.roomtype_id = roomtype_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
	}

	public long getBedNo() {
		return bedNo;
	}

	public void setBedNo(long bedNo) {
		this.bedNo = bedNo;
	}

	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}

	public int getNo_of_days() {
		return no_of_days;
	}

	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}

	public RoomTypeEntity getRoomtype_id() {
		return roomtype_id;
	}

	public void setRoomtype_id(RoomTypeEntity roomtype_id) {
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

	@Override
	public String toString() {
		return "BedAllocation [bedNo=" + bedNo + ", patient_id=" + patient_id + ", no_of_days="
				+ no_of_days + ", roomtype_id=" + roomtype_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", status=" + status + "]";
	}
	
	
	
	
}
