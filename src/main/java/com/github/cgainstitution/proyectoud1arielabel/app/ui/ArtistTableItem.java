package com.github.cgainstitution.proyectoud1arielabel.app.ui;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "artista")
public class ArtistTableItem implements Serializable {
	public static final long serialVersionUid = 1L;

	private final SimpleStringProperty mbid = new SimpleStringProperty();
	private final SimpleStringProperty nombre = new SimpleStringProperty();
	private final SimpleStringProperty oyentes = new SimpleStringProperty();

	public ArtistTableItem(String mbid, String nombre, String oyentes) {
		this.mbid.set(mbid);
		this.nombre.set(nombre);
		this.oyentes.set(oyentes);
	}

	public String getMbid() {
		return mbid.get();
	}

	public SimpleStringProperty mbidProperty() {
		return mbid;
	}

	public String getNombre() {
		return nombre.get();
	}

	public SimpleStringProperty nombreProperty() {
		return nombre;
	}

	public String getOyentes() {
		return oyentes.get();
	}

	public SimpleStringProperty oyentesProperty() {
		return oyentes;
	}
}
