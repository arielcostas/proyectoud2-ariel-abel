package com.github.cgainstitution.proyectoud1arielabel.app.models;

import java.util.Date;

public record Artista(
        Integer id,
        String name,
        Long leadStreams,
        Long feats,
        Integer tracks,
        Integer oneBillion,
        Integer hundredMillion,
        Date lastUpdated
) {
}
