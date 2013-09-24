package com.example.unpluged.model;

public class Volume implements Item {

	private String title;
	

	public Volume(String title) {
		super();
		this.title = title;
	}


	@Override
	public String getTitle() {
		return this.title;

	}

}
