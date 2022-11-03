package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageItem{

	@JsonProperty("#text")
	private String text;

	@JsonProperty("size")
	private String size;

	public String getText(){
		return text;
	}

	public String getSize(){
		return size;
	}
}