package com.example.unpluged.model;

public class Tone implements Item {

	private String title;
	

	public Tone(String title) {
		super();
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;

	}

}
