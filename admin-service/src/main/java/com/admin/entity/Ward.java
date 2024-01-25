package com.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ward")

public class Ward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ward_id")
	private int id;
	@Column(name = "ward_name")
	private String name;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "availability")
	private int availability;
	@Column(name = "medication_id")
	private int medication_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getMedication_id() {
		return medication_id;
	}

	public void setMedication_id(int medication_id) {
		this.medication_id = medication_id;
	}

	public Ward(int id, String name, int capacity, int availability, int medication_id) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.availability = availability;
		this.medication_id = medication_id;
	}

	public Ward() {

	}

	@Override
	public String toString() {
		return "Ward [id=" + id + ", ward_name=" + name + ", capacity=" + capacity + ", availability=" + availability
				+ ", medication_id=" + medication_id + "]";
	}

}
