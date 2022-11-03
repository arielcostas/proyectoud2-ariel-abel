package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link{

	@JsonProperty("#text")
	private String text;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;

	public String getText(){
		return text;
	}

	public String getRel(){
		return rel;
	}

	public String getHref(){
		return href;
	}
}