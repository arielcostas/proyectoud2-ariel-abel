package com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistSearchResults {

	@JsonProperty("results")
	private Results results;

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return
				"ArtistSearchResults{" +
						"results = '" + results + '\'' +
						"}";
	}
}