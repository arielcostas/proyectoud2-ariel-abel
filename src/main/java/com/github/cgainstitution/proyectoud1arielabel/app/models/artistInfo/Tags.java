package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags{

	@JsonProperty("tag")
	private List<TagItem> tag;

	public List<TagItem> getTag(){
		return tag;
	}
}