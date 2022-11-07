package com.github.cgainstitution.proyectoud1arielabel.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.cgainstitution.proyectoud1arielabel.app.datasource.JDBCDataSource;
import com.github.cgainstitution.proyectoud1arielabel.app.models.Artista;
import com.github.cgainstitution.proyectoud1arielabel.app.models.ListaArtistas;
import com.github.cgainstitution.proyectoud1arielabel.app.models.ResumenArtista;
import com.github.cgainstitution.proyectoud1arielabel.app.ui.ArtistTableItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
	private final JDBCDataSource dataSource;

	public MainService() {
		dataSource = new JDBCDataSource();
	}

	public List<ResumenArtista> buscarArtistas(String terminoBusqueda) {
		try {
			return dataSource.buscarArtistas(terminoBusqueda);
		} catch (IOException e) {
			System.err.println("Hubo un error buscando artistas: " + e.getMessage());
			return new ArrayList<>();
		}

	}

	/**
	 * Obtiene los datos de un artista
	 *
	 * @param mbidArtista el MBID del artista
	 * @return los datos del artista
	 */
	public Artista datosArtista(String mbidArtista) {
		try {
			return dataSource.datosArtista(mbidArtista);
		} catch (IOException e) {
			System.err.println("Hubo un error buscando artistas: " + e.getMessage());
			return null;
		}
	}

	public void guardarArtistasComoJson(ArrayList<ArtistTableItem> artistas, File destino) {
		var mapper = new ObjectMapper();
		try {
			mapper.writeValue(destino, artistas);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistasComoXML(ArrayList<ArtistTableItem> artistas, File destino) {
		var mapper = new XmlMapper();

		try {
			mapper.writeValue(destino, new ListaArtistas(artistas));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistasComoCSV(ArrayList<ArtistTableItem> artistas, File destino) {
		var mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ArtistTableItem.class);

		try (SequenceWriter sw = mapper.writer(schema).writeValues(destino)) {
			sw.write(List.of("mbid", "nombre", "oyentes"));
			sw.writeAll(artistas);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistasComoBinario(ArrayList<ArtistTableItem> artistas, File destino) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destino))) {
			oos.writeObject(
				artistas.stream().map(a -> new ResumenArtista(a.getMbid(), a.getNombre(), a.getOyentes())).collect(Collectors.toList())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void insertarArtista(Artista artista) {
		try {
			this.dataSource.insertarArtista(artista);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
