package com.github.cgainstitution.proyectoud1arielabel.app.models;

import java.io.Serializable;
import java.math.BigInteger;

public record ResumenArtista(
	Integer id,
	String name,
	Long leadStreams
) implements Serializable {
	public static final long serialVersionUID = 1L;
}