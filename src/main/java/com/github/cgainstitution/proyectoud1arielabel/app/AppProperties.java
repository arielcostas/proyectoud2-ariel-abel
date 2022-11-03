package com.github.cgainstitution.proyectoud1arielabel.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;

public class AppProperties {
	public static final String USUARIO = "app.usuario";
	public static final String CONTRASENA = "app.contrasena";
	public static final String APIKEY = "app.api-key";

	private final Properties properties;

	private static AppProperties instance;

	private AppProperties() {
		this.properties = new Properties();
		var propertiesFile = Path.of("ultimofm.properties");

		try {
			if (!Files.exists(propertiesFile)) {
				var datos = Base64.getDecoder().decode("YXBwLnVzdWFyaW89YWRtaW4KYXBwLmNvbnRyYXNlbmE9JDJhJDEyJEVDa0swVVZaZGhFY2VGaTFsejR6TU9RSFFKaUFXTkQvM1I5b2VyblZNc1VSQXlodUFWenpxCmFwcC5hcGkta2V5PTE3NTBkN2M2NGExODZkYzAwMDVmZmU0ZDk0ZTA2YjUx");
				Files.write(propertiesFile, datos);
			}

			properties.load(
					Files.newInputStream(propertiesFile)
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getProp(String propkey) {
		return getInstance().properties.getProperty(propkey);
	}

 	public static AppProperties getInstance() {
		if (instance == null) {
			instance = new AppProperties();
		}

		return instance;
	}


}
