package com.github.cgainstitution.proyectoud1arielabel.app.datasource;

import com.github.cgainstitution.proyectoud1arielabel.app.BBDD;
import com.github.cgainstitution.proyectoud1arielabel.app.models.Artista;
import com.github.cgainstitution.proyectoud1arielabel.app.models.ResumenArtista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JDBCDataSource {

	public List<ResumenArtista> buscarArtistas(String terminoBusqueda) throws IOException {
		var conn = BBDD.getConnection();
		List<ResumenArtista> resultados = new ArrayList<>();
		try {
			var stmt = conn.prepareStatement("SELECT id, name, leadStreams FROM artistas WHERE name LIKE ?");
			stmt.setString(1, "%" + terminoBusqueda + "%");
			var r = stmt.executeQuery();
			while (r.next()) {
				resultados.add(new ResumenArtista(r.getInt(1), r.getString(2), r.getLong(3)));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return resultados;
	}

	/**
	 * Obtiene los datos de un artista en base a su ID de MusicBrainz
	 *
	 * @param idArtista el ID del artista
	 * @return Los datos del artista
	 */
	public Artista datosArtista(String idArtista) throws IOException {
		var conn = BBDD.getConnection();
		try {
			var stmt = conn.prepareStatement("SELECT * FROM artistas WHERE id = ?");
			stmt.setInt(1, Integer.parseInt(idArtista));
			var r = stmt.executeQuery();
			while (r.next()) {
				return new Artista(r.getInt(1), r.getString(2), r.getLong(3), r.getLong(4), r.getInt(5), r.getInt(6), r.getInt(7), r.getDate(8));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
