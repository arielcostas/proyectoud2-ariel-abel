package com.github.cgainstitution.proyectoud1arielabel.app.controller;

import com.github.cgainstitution.proyectoud1arielabel.app.UltimoFMApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Objects;

public class DialogoLogin extends Dialog<Pair<String, String>> {
	@FXML
	private ButtonType loginButtonType;

	@FXML
	private TextField usuarioField;

	@FXML
	private PasswordField passwordField;

	public DialogoLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(UltimoFMApplication.class.getResource("dialogo-login.fxml"));
			loader.setController(this);

			DialogPane dialogPane = loader.load();

			initModality(Modality.APPLICATION_MODAL);
			setResizable(false);
			setDialogPane(dialogPane);

			setResultConverter(buttonType -> {
				if (!Objects.equals(buttonType.getButtonData(), ButtonBar.ButtonData.OK_DONE)) {
					System.exit(0);
				}

				return new Pair<>(usuarioField.getText(), passwordField.getText());
			});

			// Hace que el 'focus' esté en el campo de nombre de usuario
			setOnShowing(dialogEvent -> Platform.runLater(() -> usuarioField.requestFocus()));
		} catch (IOException e) {

			throw new RuntimeException();
		}

	}
}
