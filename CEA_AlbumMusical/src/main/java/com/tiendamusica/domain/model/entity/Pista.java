package com.tiendamusica.domain.model.entity;

import java.util.UUID;

public class Pista {

    private final UUID id;
    private String titulo;
    private int numero;
    private int duracionSegundos;

    public Pista(UUID id, String titulo, int numero,
                 int duracionSegundos) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }

        if (numero <= 0) {
            throw new IllegalArgumentException("Número de pista inválido");
        }

        if (duracionSegundos <= 0) {
            throw new IllegalArgumentException("Duración inválida");
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
