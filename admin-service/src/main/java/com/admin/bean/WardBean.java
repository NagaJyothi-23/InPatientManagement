package com.admin.bean;

public class WardBean {
	private long id;
	private String name;
	private int capacity;
	private int availability;
	private MedicationBean medicationId;
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
	public MedicationBean getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(MedicationBean medicationId) {
		this.medicationId = medicationId;
	}
	public WardBean(long id, String name, int capacity, int availability, MedicationBean medicationId) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.availability = availability;
		this.medicationId = medicationId;
	}
	public WardBean() {
		super();
	}
	@Override
	public String toString() {
		return "WardBean [id=" + id + ", name=" + name + ", capacity=" + capacity + ", availability=" + availability
				+ ", medicationId=" + medicationId + "]";
	}
}
	