package com.tiendamusica.domain.model.entity;

import java.time.LocalDate;
import java.util.UUID;

public class DerechoMusical {

    private final UUID id;
    private String tipo;
    private String titular;
    private String descripcion;
    private LocalDate vigencia;

    public DerechoMusical(UUID id, String tipo, String titular,
                          String descripcion, LocalDate vigencia) {

        if (id == null) {
            throw new IllegalArgumentException("El ID es obligatorio");
        }

        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de derecho es obligatorio");
        }

        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular es obligatorio");
        }

        this.id = id;
        this.tipo = tipo;
        this.titular = titular;
        this.descripcion = descripcion;
        this.vigencia = vigencia;
    }
}