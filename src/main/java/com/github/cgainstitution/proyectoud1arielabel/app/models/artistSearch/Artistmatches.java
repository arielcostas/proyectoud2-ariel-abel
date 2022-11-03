package com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Artistmatches {

	@JsonProperty("artist")
	private List<ArtistItem> artist;

	public List<ArtistItem> getArtist() {
		return artist;
	}

	public void setArtist(List<ArtistItem> artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return
				"Artistmatches{" +
						"artist = '" + artist + '\'' +
						"}";
	}
}