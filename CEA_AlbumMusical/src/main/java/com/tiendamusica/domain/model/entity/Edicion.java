package com.tiendamusica.domain.model.entity;

import java.util.UUID;

public class Edicion {

    private final UUID id;
    private String nombre;
    private String numeroCatalogo;
    private int anioPublicacion;
    private String formato;
    private UUID companiaDiscograficaId;

    public Edicion(UUID id, String nombre, String numeroCatalogo,
                   int anioPublicacion, String formato,
                   UUID companiaDiscograficaId) {

        if (id == null || companiaDiscograficaId == null) {
            throw new IllegalArgumentException("Los identificadores son obligatorios");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (numeroCatalogo == null || numeroCatalogo.isBlank()) {
            throw new IllegalArgumentException("El número de catálogo es obligatorio");
        }

        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("Año de publicación inválido");
        }

        this.id = id;
        this.nombre = nombre;
        this.numeroCatalogo = numeroCatalogo;
        this.anioPublicacion = anioPublicacion;
        this.formato = formato;
        this.companiaDiscograficaId = companiaDiscograficaId;
    }
}