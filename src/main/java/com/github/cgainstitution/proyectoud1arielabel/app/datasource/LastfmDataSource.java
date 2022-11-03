package com.github.cgainstitution.proyectoud1arielabel.app.datasource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cgainstitution.proyectoud1arielabel.app.AppProperties;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo.Artist;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo.ArtistInfoResponse;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch.ArtistItem;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch.ArtistSearchResults;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class LastfmDataSource implements DataSource {
	public static final String BASE_URL = "https://ws.audioscrobbler.com/2.0/";
	public static final String API_KEY = AppProperties.getProp(AppProperties.APIKEY);

	public List<ArtistItem> buscarArtistas(String terminoBusqueda) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		var url = new URL(
				BASE_URL +
						"?method=" + LastfmRequestMethods.ARTIST_SEARCH +
						"&artist=" + URLEncoder.encode(terminoBusqueda, StandardCharsets.UTF_8) +
						"&format=" + "json" +
						"&api_key=" + API_KEY
		);

		var resultadoConsulta = mapper.readValue(url, ArtistSearchResults.class);
		return resultadoConsulta.getResults().getArtistmatches().getArtist();
	}

	/**
	 * Obtiene los datos de un artista en base a su ID de MusicBrainz
	 * @param mbidArtista el ID del artista
	 * @return Los datos del artista
	 * @throws IOException Si hay algún problema deserializando por parte de Jackson
	 */
	public Artist datosArtista(String mbidArtista) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		var url = new URL(
				BASE_URL +
						"?method=" + LastfmRequestMethods.ARTIST_INFO +
						"&mbid=" + URLEncoder.encode(mbidArtista, StandardCharsets.UTF_8) +
						"&format=" + "json" +
						"&lang=" + "es" +
						"&api_key=" + API_KEY
		);

		var consultaIA = mapper.readValue(url, ArtistInfoResponse.class);
		return consultaIA.getArtist();
	}
}
