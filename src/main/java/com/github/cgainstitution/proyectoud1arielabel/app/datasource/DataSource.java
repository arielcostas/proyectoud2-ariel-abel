package com.github.cgainstitution.proyectoud1arielabel.app.datasource;

import com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo.Artist;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch.ArtistItem;

import java.io.IOException;
import java.util.List;

public interface DataSource {
	List<ArtistItem> buscarArtistas(String terminoBusqueda) throws IOException;

	Artist datosArtista(String mbidArtista) throws IOException;
}
