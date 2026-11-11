package com.tiendamusica.domain.model.entity;

import com.tiendamusica.domain.exception.InvalidTrackException;

import java.util.UUID;

public class Pista {

    private final UUID id;
    private String titulo;
    private int numero;
    private int duracionSegundos;

    public Pista(UUID id, String titulo, int numero,
                 int duracionSegundos) {

        if (id == null) {
            throw new InvalidTrackException("El ID de la pista es obligatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new InvalidTrackException("El título de la pista es obligatorio");
        }

        if (numero <= 0) {
            throw new InvalidTrackException("El número de pista debe ser mayor que cero");
        }

        if (duracionSegundos <= 0) {
            throw new InvalidTrackException("La duración debe ser mayor que cero");
        }

        this.id = id;
        this.titulo = titulo;
        this.numero = numero;
        this.duracionSegundos = duracionSegundos;
    }

    public UUID getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }
}
