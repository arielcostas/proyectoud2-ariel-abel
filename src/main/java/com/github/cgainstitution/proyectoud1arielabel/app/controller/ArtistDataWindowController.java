package com.github.cgainstitution.proyectoud1arielabel.app.controller;

import com.github.cgainstitution.proyectoud1arielabel.app.dto.ArtistaDetallesDto;
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

public class ArtistDataWindowController {
    @FXML
    public Label nombre;
    @FXML
    public Label biografia;
    @FXML
    public Label tags;
    @FXML
    public Label oyentes;
    @FXML
    public Label reproducciones;

    @FXML
    public ImageView imagenArtista;

    /**
     * La escena de la ventana principal, usada en el botón volver
     */
    public Scene escenaBase;

    private final ArtistDataService artistDataService = new ArtistDataService();
    private ArtistaDetallesDto artist;

    public void initData(ArtistaDetallesDto artist, Scene escenaBase) {
        this.artist = artist;
        this.nombre.setText(artist.nombre());
        this.biografia.setText(artist.biografia());
        this.tags.setText(artist.tags());
        this.oyentes.setText(artist.oyentes());
        this.reproducciones.setText(artist.reproducciones());
        this.imagenArtista.setImage(
                new Image(artist.imagenArtista())
        );
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
                artistDataService.guardarArtistaComoJson(
                        artist, archivoDondeGuardar
                );
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
                artistDataService.guardarArtistaComoXML(
                        artist, archivoDondeGuardar
                );
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
                artistDataService.guardarArtistaComoCSV(
                        artist, archivoDondeGuardar
                );
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
                artistDataService.guardarArtistaComoBinario(
                        artist, archivoDondeGuardar
                );
            } catch (RuntimeException e) {
                var alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Error guardando como Binario");
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            }
        }
    }

}
