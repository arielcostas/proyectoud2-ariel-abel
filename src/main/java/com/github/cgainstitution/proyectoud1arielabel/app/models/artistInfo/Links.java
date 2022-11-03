package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{

	@JsonProperty("link")
	private Link link;

	public Link getLink(){
		return link;
	}
}