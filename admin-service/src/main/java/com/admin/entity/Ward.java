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
@Table(name = "ward")

public class Ward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wardId")
	private long id;
	@Column(name = "wardName")
	private String name;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "availability")
	private int availability;
	@ManyToOne
	@JoinColumn(name = "medicationId",referencedColumnName = "id")
	private Medication medicationId;

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

	public Medication getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Medication medicationId) {
		this.medicationId = medicationId;
	}

	public Ward(long id, String name, int capacity, int availability, Medication medicationId) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.availability = availability;
		this.medicationId = medicationId;
	}

	public Ward() {
		super();
	}

	@Override
	public String toString() {
		return "Ward [id=" + id + ", name=" + name + ", capacity=" + capacity + ", availability=" + availability
				+ ", medicationId=" + medicationId + "]";
	}

}

	