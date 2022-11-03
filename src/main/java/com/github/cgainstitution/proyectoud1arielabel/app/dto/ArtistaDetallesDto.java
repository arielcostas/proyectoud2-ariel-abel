package com.github.cgainstitution.proyectoud1arielabel.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "artista")
public record ArtistaDetallesDto(
		String nombre,
		String biografia,
		String tags,
		String oyentes,
		String reproducciones,
		String imagenArtista
) implements Serializable {
}
