package com.github.cgainstitution.proyectoud1arielabel.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.cgainstitution.proyectoud1arielabel.app.datasource.JDBCDataSource;
import com.github.cgainstitution.proyectoud1arielabel.app.dto.ArtistaDetallesDto;
import com.github.cgainstitution.proyectoud1arielabel.app.dto.ArtistaDto;
import com.github.cgainstitution.proyectoud1arielabel.app.dto.ListaArtistas;
import com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo.TagItem;
import com.github.cgainstitution.proyectoud1arielabel.app.ui.ArtistTableItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
	private final JDBCDataSource JDBCDataSource;

	public MainService() {
		JDBCDataSource = new JDBCDataSource();
	}

	public List<ArtistaDto> buscarArtistas(String terminoBusqueda) {
		try {
			var artistas = JDBCDataSource.buscarArtistas(terminoBusqueda);
			return artistas
					.stream()
					.filter(a -> !a.getMbid().equals(""))
					.map(a -> new ArtistaDto(a.getMbid(), a.getName(), a.getListeners()))
					.collect(Collectors.toList());
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
	public ArtistaDetallesDto datosArtista(String mbidArtista) {
		try {
			var artista = JDBCDataSource.datosArtista(mbidArtista);

			// Obtener la imagen en tamaño mediano del artista.
			var imgUrl = artista.getImage().get(2).getText();
			// Si la imagen no existe, la URL será una cadena vacía y JavaFX no funcionará bien. Por tanto, se remplaza por el logo.
			if (imgUrl.equals("")) {
				imgUrl = "file:logo.png";
			}

			return new ArtistaDetallesDto(
					artista.getName(),
					artista.getBio().getSummary().split("<a href=")[0],
					artista.getTags().getTag().stream().map(TagItem::getName).collect(Collectors.joining(", ")),
					artista.getStats().getListeners(),
					artista.getStats().getPlaycount(),
					imgUrl
			);
		} catch (IOException e) {
			System.err.println("Hubo un error recuperando el artista: " + e.getMessage());
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
					artistas.stream().map(a -> new ArtistaDto(a.getMbid(), a.getNombre(), a.getOyentes())).collect(Collectors.toList())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
