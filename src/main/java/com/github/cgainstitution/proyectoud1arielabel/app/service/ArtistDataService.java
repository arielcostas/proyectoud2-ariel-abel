package com.github.cgainstitution.proyectoud1arielabel.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.cgainstitution.proyectoud1arielabel.app.dto.ArtistaDetallesDto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArtistDataService {
	public void guardarArtistaComoJson(ArtistaDetallesDto artista, File destino) {
		var mapper = new ObjectMapper();
		try {
			mapper.writeValue(destino, artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoXML(ArtistaDetallesDto artista, File destino) {
		var mapper = new XmlMapper();

		try {
			mapper.writeValue(destino, artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoCSV(ArtistaDetallesDto artista, File destino) {
		var mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(ArtistaDetallesDto.class);

		try (SequenceWriter sw = mapper.writer(schema).writeValues(destino)) {
			sw.write(List.of("nombre", "biografia", "tags", "oyentes", "reproducciones", "imagenArtista"));
			sw.write(artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarArtistaComoBinario(ArtistaDetallesDto artista, File destino) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destino))) {
			oos.writeObject(artista);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
