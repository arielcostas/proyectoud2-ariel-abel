module com.github.cgainstitution.proyectoud1arielabel.app {
	requires javafx.controls;
	requires javafx.fxml;

	requires password4j;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.dataformat.xml;
	requires com.fasterxml.jackson.dataformat.csv;

	requires java.sql;
	requires mysql.connector.java;

	exports com.github.cgainstitution.proyectoud1arielabel.app;
	opens com.github.cgainstitution.proyectoud1arielabel.app to javafx.fxml;
	exports com.github.cgainstitution.proyectoud1arielabel.app.controller;

	opens com.github.cgainstitution.proyectoud1arielabel.app.models.artistSearch to com.fasterxml.jackson.databind;
	opens com.github.cgainstitution.proyectoud1arielabel.app.models.artistInfo to com.fasterxml.jackson.databind;
	exports com.github.cgainstitution.proyectoud1arielabel.app.dto;
	opens com.github.cgainstitution.proyectoud1arielabel.app.dto to com.fasterxml.jackson.databind, javafx.fxml;
	exports com.github.cgainstitution.proyectoud1arielabel.app.ui;
	opens com.github.cgainstitution.proyectoud1arielabel.app.ui to com.fasterxml.jackson.databind, javafx.fxml;
	opens com.github.cgainstitution.proyectoud1arielabel.app.controller to com.fasterxml.jackson.databind, javafx.fxml;
}