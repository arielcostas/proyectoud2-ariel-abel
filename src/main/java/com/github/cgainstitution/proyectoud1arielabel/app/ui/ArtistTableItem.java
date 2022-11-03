package com.github.cgainstitution.proyectoud1arielabel.app.ui;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "artista")
public class ArtistTableItem implements Serializable {
	public static final long serialVersionUid = 1L;

	private final SimpleIntegerProperty mbid = new SimpleIntegerProperty();
	private final SimpleStringProperty nombre = new SimpleStringProperty();
	private final SimpleLongProperty oyentes = new SimpleLongProperty();

	public ArtistTableItem(Integer mbid, String nombre, Long oyentes) {
		this.mbid.set(mbid);
		this.nombre.set(nombre);
		this.oyentes.set(oyentes);
	}

	public Integer getMbid() {
		return mbid.get();
	}

	public SimpleIntegerProperty mbidProperty() {
		return mbid;
	}

	public String getNombre() {
		return nombre.get();
	}

	public SimpleStringProperty nombreProperty() {
		return nombre;
	}

	public Long getOyentes() {
		return oyentes.get();
	}

	public SimpleLongProperty oyentesProperty() {
		return oyentes;
	}
}
