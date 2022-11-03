package com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	@JsonProperty("artistmatches")
	private Artistmatches artistmatches;

	public Artistmatches getArtistmatches() {
		return artistmatches;
	}

	@Override
	public String toString() {
		return "Results{" +
				"artistmatches=" + artistmatches +
				'}';
	}
}