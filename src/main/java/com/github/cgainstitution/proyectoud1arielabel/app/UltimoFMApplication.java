package com.github.cgainstitution.proyectoud1arielabel.app;

import com.github.cgainstitution.proyectoud1arielabel.app.controller.DialogoLogin;
import com.password4j.types.Bcrypt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.password4j.BcryptFunction;

import java.io.IOException;
import java.util.Objects;

public class UltimoFMApplication extends Application {
	public static final int APP_MINIMUM_WIDTH = 800;
	public static final int APP_MINIMUM_HEIGHT = 600;

	@Override
	public void start(Stage stage) throws IOException {
		// Login fallido
		boolean sesion_iniciada = false;
		while (!sesion_iniciada) {
			if (doLogin()) {
				sesion_iniciada = true;
			} else {
				var alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText("Credenciales incorrectas");
				alerta.showAndWait();
			}
		}

		FXMLLoader fxmlLoader = new FXMLLoader(UltimoFMApplication.class.getResource("main-window.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), APP_MINIMUM_WIDTH, APP_MINIMUM_HEIGHT);

		stage.setWidth(APP_MINIMUM_HEIGHT);
		stage.setHeight(APP_MINIMUM_HEIGHT);
		stage.setMinWidth(APP_MINIMUM_WIDTH);
		stage.setMinHeight(APP_MINIMUM_HEIGHT);

		stage.setTitle("ÚltimoFM");
		stage.getIcons().add(new Image(Objects.requireNonNull(UltimoFMApplication.class.getResourceAsStream("logo.png"))));
		stage.setScene(scene);
		stage.show();
		stage.toFront();
	}

	public boolean doLogin() {
		DialogoLogin dialogo = null;
		try {
			dialogo = new DialogoLogin();
			dialogo.setTitle("Inicio de sesión - ÚltimoFM");
			var stage = (Stage) dialogo.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(Objects.requireNonNull(UltimoFMApplication.class.getResourceAsStream("logo.png"))));
		} catch (Exception e) {
			System.exit(1);
		}
		var correct = false;
		var resultadoDialogo = dialogo.showAndWait();

		if (resultadoDialogo.isPresent()) {
			var result = resultadoDialogo.get();

			var usuario = result.getKey();
			var contrasena = result.getValue();

			correct = Objects.equals(AppProperties.getProp(AppProperties.USUARIO), usuario) && BcryptFunction.getInstance(Bcrypt.A, 12).check(contrasena, AppProperties.getProp(AppProperties.CONTRASENA));
		}
		return correct;
	}

	public static void main(String[] args) {
		launch();
	}
}