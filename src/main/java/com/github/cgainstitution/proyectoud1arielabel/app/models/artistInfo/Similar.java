package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Similar{

	@JsonProperty("artist")
	private List<ArtistItem> artist;

	public List<ArtistItem> getArtist(){
		return artist;
	}
}