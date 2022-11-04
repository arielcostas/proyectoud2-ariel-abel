package com.github.cgainstitution.proyectoud1arielabel.app.controller;

import com.github.cgainstitution.proyectoud1arielabel.app.models.Artista;
import com.github.cgainstitution.proyectoud1arielabel.app.service.ArtistDataService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.text.SimpleDateFormat;

public class ArtistDataWindowController {
	@FXML
	public Label nombre;
	@FXML
	public Label leadStreams;
	@FXML
	public Label feats;
	@FXML
	public Label tracks;
	@FXML
	public Label oneBillion;
	@FXML
	public Label hundredMillion;
	@FXML
	public Label lastUpdated;

	/**
	 * La escena de la ventana principal, usada en el botón volver
	 */
	public Scene escenaBase;

	private final ArtistDataService artistDataService = new ArtistDataService();
	private Artista artista;

	public void initData(Artista artist, Scene escenaBase) {
		this.artista = artist;
		this.nombre.setText(artist.name());

		this.nombre.setText(artist.name());
		this.leadStreams.setText(String.valueOf(artist.leadStreams()));
		this.feats.setText(String.valueOf(artist.feats()));
		this.tracks.setText(String.valueOf(artist.tracks()));
		this.oneBillion.setText(String.valueOf(artist.oneBillion()));
		this.hundredMillion.setText(String.valueOf(artist.hundredMillion()));
		this.lastUpdated.setText(new SimpleDateFormat("dd/MM/yyyy").format(artist.lastUpdated()));
		this.escenaBase = escenaBase;
	}

	public void salir(ActionEvent event) {
		Platform.exit();
	}

	public void volver(ActionEvent event) {
		var stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(escenaBase);
		stage.show();
	}

	public void guardarJson(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como JSON");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JavaScript Object Notation", "*.json"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			if (!archivoDondeGuardar.getName().endsWith(".json")) {
				archivoDondeGuardar = new File(archivoDondeGuardar + ".json");
			}
			try {
				artistDataService.guardarArtistaComoJson(artista, archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como JSON");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void guardarXml(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como XML");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("eXtensible Markup Language (*.xml)", "*.xml"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				artistDataService.guardarArtistaComoXML(artista, archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como XML");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void guardarCsv(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como Texto");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Texto (*.txt)", "*.txt"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				artistDataService.guardarArtistaComoCSV(artista, archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como Texto");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void guardarBin(ActionEvent actionEvent) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como binario");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Binar10 (*.bin)", "*.bin"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				artistDataService.guardarArtistaComoBinario(artista, archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como Binario");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

}
