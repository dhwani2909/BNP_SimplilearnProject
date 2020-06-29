package com.file.model;

public class FileHandler{
	private int id;
	private String name;
	private String location;
	private Float size;
	private String attribute;
	
	

	public FileHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileHandler(String name, String location, Float size, String attribute) {
		super();
		this.name = name;
		this.location = location;
		this.size = size;
		this.attribute = attribute;
	}
	
	public FileHandler(String name) {
		super();
		this.name = name;
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
