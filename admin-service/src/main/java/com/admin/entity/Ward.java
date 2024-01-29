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
	@Column(name = "ward_id")
	private long ward_id;
	@Column(name = "ward_name")
	private String ward_name;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "availability")
	private int availability;
	@ManyToOne
	@JoinColumn(name = "medication_id",referencedColumnName = "id")
	private Medication medication_id;

	public long getWard_id() {
		return ward_id;
	}

	public void setWard_id(long ward_id) {
		this.ward_id = ward_id;
	}

	public String getWard_name() {
		return ward_name;
	}

	public void setWard_name(String ward_name) {
		this.ward_name = ward_name;
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

	public Ward(int ward_id, String ward_name, int capacity, int availability, Medication medication_id) {
		this.ward_id = ward_id;
		this.ward_name = ward_name;
		this.capacity = capacity;
		this.availability = availability;
		this.medication_id = medication_id;
	}

	public Ward() {

	}

	@Override
	public String toString() {
		return "Ward [ward_id=" + ward_id + ", ward_name=" + ward_name + ", capacity=" + capacity + ", availability="
				+ availability + ", medication_id=" + medication_id + "]";
	}

}
