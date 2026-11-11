package com.tiendamusica.domain.model.entity;

import java.util.UUID;

public class Artista {

    private final UUID id;
    private String nombre;
    private String tipo;
    private String descripcion;

    public Artista(UUID id, String nombre, String tipo,
                   String descripcion) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de artista es obligatorio");
        }

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
}