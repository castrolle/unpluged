package com.example.unpluged.model;

public class Vibration implements Item {

	private String title;
	
	public Vibration(String title) {
		super();
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;

	}

}

