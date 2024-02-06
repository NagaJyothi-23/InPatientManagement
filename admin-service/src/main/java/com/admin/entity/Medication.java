package com.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medication_type")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="medicationName")
	private String medicationName;
	
	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Medication(String medicationName) {
		super();
		this.medicationName = medicationName;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getMedicationName() {
		return medicationName;
	}



	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}



	@Override
	public String toString() {
		return "Medication [id=" + id + ", medicationName=" + medicationName + "]";
	}

    
	
}
