package com.snippetdump.tutobjectsactivities.model;

public class SampleObject {

	private int id;
	private String name;
	private long date;
	
	public SampleObject(){}
	
	public SampleObject(int id, String name, long date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
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
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	
	
}
