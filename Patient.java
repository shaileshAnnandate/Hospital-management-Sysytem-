package com.lss.patient.Hospital.hospitalEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Patient {

	private int id;
	private String name;
	private int age;
	private String village;
	
	
	
	@Id
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", village=" + village + "]";
	}
	
	
}
