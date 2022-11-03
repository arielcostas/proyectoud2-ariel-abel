package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}