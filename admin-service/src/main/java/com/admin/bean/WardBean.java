package com.admin.bean;

import com.admin.entity.Medication;


public class WardBean {
	private long id;
	private String name;
	private int capacity;
	private int availability;
	private Medication medication_id;
	public long getId() {
		return id;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public Medication getMedication_id() {
		return medication_id;
	}
	public void setMedication_id(Medication medication_id) {
		this.medication_id = medication_id;
	}
	public WardBean(long id, String name, int capacity, int availability, Medication medication_id) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.availability = availability;
		this.medication_id = medication_id;
	}
	public WardBean() {
		super();
	}
	@Override
	public String toString() {
		return "WardBean [id=" + id + ", name=" + name + ", capacity=" + capacity + ", availability=" + availability
				+ ", medication_id=" + medication_id + "]";
	}
	

}
