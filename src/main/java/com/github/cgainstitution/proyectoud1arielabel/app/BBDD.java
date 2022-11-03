package com.github.cgainstitution.proyectoud1arielabel.app;

import java.sql.*;

public class BBDD {
    // Conexión ya existente
    private static Connection conexion;

    public static Connection getConnection() {
        if (conexion == null) {
            // TODO: Usar credenciales leídas de entorno
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoud2_ariel_abel", "jdbc", "jdbc");
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return conexion;
    }
}
