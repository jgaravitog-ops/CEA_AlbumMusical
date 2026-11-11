package com.tiendamusica.domain.model.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Coleccion {

    private final UUID id;
    private String nombre;
    private String descripcion;
    private final Set<UUID> cds;

    public Coleccion(UUID id, String nombre, String descripcion) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cds = new HashSet<>();
    }

    public void agregarCD(UUID cdId) {
        if (cdId == null) {
            throw new IllegalArgumentException("El CD es obligatorio");
        }

        cds.add(cdId);
    }
}
