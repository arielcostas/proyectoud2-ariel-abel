package com.github.cgainstitution.proyectoud1arielabel.app.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.github.cgainstitution.proyectoud1arielabel.app.ui.ArtistTableItem;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "artistas")
public class ListaArtistas {
    @JacksonXmlElementWrapper(useWrapping = false)
    public ArrayList<ArtistTableItem> artista;

    public ListaArtistas(ArrayList<ArtistTableItem> artistas) {
        this.artista = artistas;
    }
}