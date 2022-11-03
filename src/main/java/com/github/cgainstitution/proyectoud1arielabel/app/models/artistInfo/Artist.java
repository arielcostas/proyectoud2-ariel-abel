package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist{

	@JsonProperty("image")
	private List<ImageItem> image;

	@JsonProperty("similar")
	private Similar similar;

	@JsonProperty("mbid")
	private String mbid;

	@JsonProperty("streamable")
	private String streamable;

	@JsonProperty("stats")
	private Stats stats;

	@JsonProperty("name")
	private String name;

	@JsonProperty("ontour")
	private String ontour;

	@JsonProperty("bio")
	private Bio bio;

	@JsonProperty("url")
	private String url;

	@JsonProperty("tags")
	private Tags tags;

	public List<ImageItem> getImage(){
		return image;
	}

	public Similar getSimilar(){
		return similar;
	}

	public String getMbid(){
		return mbid;
	}

	public String getStreamable(){
		return streamable;
	}

	public Stats getStats(){
		return stats;
	}

	public String getName(){
		return name;
	}

	public String getOntour(){
		return ontour;
	}

	public Bio getBio(){
		return bio;
	}

	public String getUrl(){
		return url;
	}

	public Tags getTags(){
		return tags;
	}
}