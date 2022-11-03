package com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistInfoResponse {

	@JsonProperty("artist")
	private Artist artist;

	public Artist getArtist(){
		return artist;
	}
}