package com.github.cgainstitution.proyectoud1arielabel.app;

import java.sql.*;

public class BBDD {
    // Conexión ya existente
    private static Connection conexion;

    public static Connection getConnection() {
        if (conexion == null) {
            // Leer valores de configuración desde entorno
			String url = System.getenv("DB_URL");
			String user = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");

			// Fijar valores por defecto si no están definidos
			if (url == null) {
				url = "jdbc:mysql://dam-aad-ud2.mysql.database.azure.com:3306/proyectoud2_ariel_abel";
			}
			if (user == null) {
				user = "usuario_artistas";
			}
			if (password == null) {
				password = "yYTng2wg";
			}

			// Crear conexión
            try {
                conexion = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return conexion;
    }
}
