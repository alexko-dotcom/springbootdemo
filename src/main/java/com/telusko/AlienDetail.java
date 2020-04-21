package com.telusko;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AlienDetail {
	private int alienDetailId;
	
	 private String job;
	 private String zipCode;
	public String getJob() {
		return job;
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="detailId_PK")
	public int getAlienDetailId() {
		return alienDetailId;
	}
	public void setAlienDetailId(int alienDetailId) {
		this.alienDetailId = alienDetailId;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	 
	 
}
