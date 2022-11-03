package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistItem{

	@JsonProperty("image")
	private List<ImageItem> image;

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public List<ImageItem> getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}