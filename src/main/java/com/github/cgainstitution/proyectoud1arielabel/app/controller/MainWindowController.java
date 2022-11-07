package com.github.cgainstitution.proyectoud1arielabel.app.controller;

import com.github.cgainstitution.proyectoud1arielabel.app.UltimoFMApplication;
import com.github.cgainstitution.proyectoud1arielabel.app.service.MainService;
import com.github.cgainstitution.proyectoud1arielabel.app.ui.ArtistTableItem;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainWindowController {
	/**
	 * Los elementos de la tabla con el listado de artistas. Por defecto, tiene un elemento nulo
	 * en lugar de estar vacío para evitar
	 */
	private final ObservableList<ArtistTableItem> artistSearchResults = FXCollections.observableArrayList((ArtistTableItem) null);

	private final MainService mainService = new MainService();

	@FXML
	public TableView<ArtistTableItem> tablaResultadosBusqueda;

	public ObservableList<ArtistTableItem> getArtistSearchResults() {
		return artistSearchResults;
	}

	@FXML
	private TextField busquedaArtista;

	@FXML
	protected void onBuscar() {
		if (busquedaArtista.getText().equals("")) {
			return;
		}

		var task = new Task() {

			@Override
			protected Object call() {
				artistSearchResults.clear();
				var scene = busquedaArtista.getScene();
				scene.setCursor(Cursor.WAIT);
				mainService.buscarArtistas(busquedaArtista.getText()).forEach(artista -> {
					artistSearchResults.add(new ArtistTableItem(artista.id(), artista.name(), artista.leadStreams()));
				});
				scene.setCursor(Cursor.DEFAULT);
				return null;
			}
		};
		var th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}


	/**
	 * Método llamado al inicializar el controlador
	 */
	@FXML
	protected void initialize() {
		tablaResultadosBusqueda.setRowFactory(tabla -> {
			var row = new TableRow<ArtistTableItem>();
			row.setOnMouseClicked(event -> {
				var window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				mostrarPaginaDeArtista(window, String.valueOf(row.getItem().getMbid()));
			});
			return row;
		});
	}

	/**
	 * Método para mostrar página de detalles del artista, remplazando la vista actual.
	 *
	 * @param stage el Stage (ventana) actual, para poder cambiar la página
	 * @param mbid  El mbid del artista que se desea consultar
	 */
	public void mostrarPaginaDeArtista(Stage stage, String mbid) {
		FXMLLoader loader = new FXMLLoader(UltimoFMApplication.class.getResource("artistdata-window.fxml"));

		Scene scene;
		try {
			scene = new Scene(loader.load(), UltimoFMApplication.APP_MINIMUM_WIDTH, UltimoFMApplication.APP_MINIMUM_HEIGHT);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		ArtistDataWindowController nc = loader.getController();

		var artista = mainService.datosArtista(mbid);
		if (artista == null) {
			var alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText("Error recuperando artista");
			alerta.setContentText("No se ha podido obtener el artista solicitado");
			alerta.showAndWait();
			return;
		}

		nc.initData(artista, stage.getScene());

		stage.setScene(scene);
	}

	public void onSalir() {
		Platform.exit();
	}

	public void onGuardarJson(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como JSON");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JavaScript Object Notation", "*.json"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				mainService.guardarArtistasComoJson(new ArrayList<>(artistSearchResults), archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como JSON");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void onGuardarXml(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como XML");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("eXtensible Markup Language (*.xml)", "*.xml"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				mainService.guardarArtistasComoXML(new ArrayList<>(artistSearchResults), archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como XML");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void onGuardarTexto(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como Texto");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Texto (*.txt)", "*.txt"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				mainService.guardarArtistasComoCSV(new ArrayList<>(artistSearchResults), archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como Texto");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void onGuardarBinario(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar como binario");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Binar10 (*.bin)", "*.bin"));
		File archivoDondeGuardar = fileChooser.showSaveDialog(null);

		if (archivoDondeGuardar != null) {
			try {
				mainService.guardarArtistasComoBinario(new ArrayList<>(artistSearchResults), archivoDondeGuardar);
			} catch (RuntimeException e) {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Error guardando como Binario");
				alerta.setContentText(e.getMessage());
				alerta.showAndWait();
			}
		}
	}

	public void onInsertar(ActionEvent event) {
		DialogoCrear dialogo = null;
		try {
			dialogo = new DialogoCrear();
			dialogo.setTitle("Insertar artista - ÚltimoFM");
			var stage = (Stage) dialogo.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(Objects.requireNonNull(UltimoFMApplication.class.getResourceAsStream("logo.png"))));
		} catch (Exception e) {
			System.exit(1);
		}
		var resultadoDialogo = dialogo.showAndWait();

		// Si no se ha cancelado
		resultadoDialogo.ifPresent(artista -> {
			try {
				mainService.insertarArtista(artista);
			} catch (RuntimeException e) {
				System.out.println("Error guardando artista: " + e.getMessage());
			}
		});
	}
}