package com.example.unpluged.model;


public class AlarmType implements Item {

	private String title;
	
	public AlarmType(String title) {
		super();
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;

	}

}
