package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bio{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("published")
	private String published;

	@JsonProperty("content")
	private String content;

	public String getSummary(){
		return summary;
	}

	public Links getLinks(){
		return links;
	}

	public String getPublished(){
		return published;
	}

	public String getContent(){
		return content;
	}
}