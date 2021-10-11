package com.example.demo;

import org.postgis.PGgeometry;

public class Temp {
	
	private int id;
	private String name;
	private String shape;
	public Temp() {
		// TODO Auto-generated constructor stub
	}
	
	public Temp(int id,String name,String shape) {
		this.id = id;
		this.name = name;
		this.shape = shape;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setShape(String id) {
		this.shape = id;
	}
	
	public String getShape() {
		return shape;
	}

}
