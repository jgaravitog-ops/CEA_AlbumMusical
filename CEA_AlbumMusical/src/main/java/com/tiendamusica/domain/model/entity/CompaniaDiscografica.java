package com.tiendamusica.domain.model.entity;

import java.util.UUID;

public class CompaniaDiscografica {

    private final UUID id;
    private String nombre;
    private String pais;
    private String descripcion;

    public CompaniaDiscografica(UUID id, String nombre,
                                String pais, String descripcion) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.descripcion = descripcion;
    }
}