package com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistItem {

	@JsonProperty("image")
	private List<ImageItem> image;

	@JsonProperty("mbid")
	private String mbid;

	@JsonProperty("listeners")
	private String listeners;

	@JsonProperty("streamable")
	private String streamable;

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public List<ImageItem> getImage() {
		return image;
	}

	public void setImage(List<ImageItem> image) {
		this.image = image;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getListeners() {
		return listeners;
	}

	public void setListeners(String listeners) {
		this.listeners = listeners;
	}

	public String getStreamable() {
		return streamable;
	}

	public void setStreamable(String streamable) {
		this.streamable = streamable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return
				"ArtistItem{" +
						"image = '" + image + '\'' +
						",mbid = '" + mbid + '\'' +
						",listeners = '" + listeners + '\'' +
						",streamable = '" + streamable + '\'' +
						",name = '" + name + '\'' +
						",url = '" + url + '\'' +
						"}";
	}
}