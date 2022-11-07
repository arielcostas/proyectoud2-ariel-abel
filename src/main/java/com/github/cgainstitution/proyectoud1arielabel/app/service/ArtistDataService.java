package com.github.cgainstitution.proyectoud1arielabel.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.cgainstitution.proyectoud1arielabel.app.datasource.JDBCDataSource;
import com.github.cgainstitution.proyectoud1arielabel.app.models.Artista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class ArtistDataService {
	private final JDBCDataSource dataSource;

	public ArtistDataService() {
		dataSource = new JDBCDataSource();
	}

	public void eliminarArtista(int id) {
		try {
			this.dataSource.eliminarPorId(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoJson(Artista artista, File destino) {
		var mapper = new ObjectMapper();
		try {
			mapper.writeValue(destino, artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoXML(Artista artista, File destino) {
		var mapper = new XmlMapper();

		try {
			mapper.writeValue(destino, artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoCSV(Artista artista, File destino) {
		var mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Artista.class);

		try (SequenceWriter sw = mapper.writer(schema).writeValues(destino)) {
			sw.write(List.of("id", "name", "leadStreams", "feats", "tracks", "oneBillion", "hundredMillion", "lastUpdated"));
			sw.write(List.of(
				artista.id(),
				artista.name(),
				artista.leadStreams(),
				artista.feats(),
				artista.tracks(),
				artista.oneBillion(),
				artista.hundredMillion(),
				new SimpleDateFormat("yyyy-MM-dd").format(artista.lastUpdated())
			));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoBinario(Artista artista, File destino) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destino))) {
			oos.writeObject(artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
