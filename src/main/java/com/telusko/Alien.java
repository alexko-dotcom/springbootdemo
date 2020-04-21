package com.telusko;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Alien {
	


	@Id
	@GeneratedValue
	private int id;
	private String name; 
	private int points;
	
	
	private AlienDetail alienDetail;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="pDetail_FK")
	public AlienDetail getAlienDetail() {
		return alienDetail;
	}

	public void setAlienDetail(AlienDetail alienDetail) {
		this.alienDetail = alienDetail;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	

}
