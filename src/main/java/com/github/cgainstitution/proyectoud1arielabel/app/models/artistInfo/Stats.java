package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats{

	@JsonProperty("listeners")
	private String listeners;

	@JsonProperty("playcount")
	private String playcount;

	public String getListeners(){
		return listeners;
	}

	public String getPlaycount(){
		return playcount;
	}
}