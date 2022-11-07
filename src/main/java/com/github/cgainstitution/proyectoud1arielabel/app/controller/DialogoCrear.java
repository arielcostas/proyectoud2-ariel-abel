package com.github.cgainstitution.proyectoud1arielabel.app.controller;

import com.github.cgainstitution.proyectoud1arielabel.app.UltimoFMApplication;
import com.github.cgainstitution.proyectoud1arielabel.app.models.Artista;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class DialogoCrear extends Dialog<Artista> {
	@FXML private TextField name;
	@FXML private TextField leadStreams;
	@FXML private TextField feats;
	@FXML private TextField tracks;
	@FXML private TextField oneBillion;
	@FXML private TextField hundredMillion;

	public DialogoCrear() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UltimoFMApplication.class.getResource("dialogo-insertar.fxml"));
			loader.setController(this);

			DialogPane dialogPane = loader.load();

			initModality(Modality.APPLICATION_MODAL);
			setResizable(false);
			setDialogPane(dialogPane);

			setResultConverter(buttonType -> {
				if (!Objects.equals(buttonType.getButtonData(), ButtonBar.ButtonData.OK_DONE)) {
					System.exit(0);
				}

				return new Artista(
					null,
					name.getText(),
					Long.parseLong(leadStreams.getText()),
					Long.parseLong(feats.getText()),
					Integer.parseInt(tracks.getText()),
					Integer.parseInt(oneBillion.getText()),
					Integer.parseInt(hundredMillion.getText()),
					new Date()
				);
			});

			// Hace que el 'focus' esté en el campo de nombre
			setOnShowing(dialogEvent -> Platform.runLater(() -> name.requestFocus()));
		} catch (IOException e) {
			throw new RuntimeException();
		} catch (NumberFormatException e) {
			// TODO: Decirle al usuario que su input está mal
		}

	}

}
