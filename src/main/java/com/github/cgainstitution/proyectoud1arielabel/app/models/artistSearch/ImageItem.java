package com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageItem {

	@JsonProperty("#text")
	private String text;

	@JsonProperty("size")
	private String size;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return
				"ImageItem{" +
						"#text = '" + text + '\'' +
						",size = '" + size + '\'' +
						"}";
	}
}