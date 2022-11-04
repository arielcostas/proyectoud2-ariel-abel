package com.github.cgainstitution.proyectoud1arielabel.app.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.Date;

@JacksonXmlRootElement(localName = "artista")
public record Artista(
	Integer id,
	String name,
	Long leadStreams,
	Long feats,
	Integer tracks,
	Integer oneBillion,
	Integer hundredMillion,
	Date lastUpdated
) implements Serializable {
	public static final long serialVersionUID = 1L;
}
