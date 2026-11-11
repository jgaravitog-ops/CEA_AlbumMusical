package com.tiendamusica.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Inventario {

    private final UUID id;
    private final UUID cdId;
    private int cantidadDisponible;
    private LocalDateTime fechaActualizacion;

    public Inventario(UUID id, UUID cdId, int cantidadDisponible) {

        if (id == null || cdId == null) {
            throw new IllegalArgumentException("Los identificadores son obligatorios");
        }

        if (cantidadDisponible < 0) {
            throw new IllegalArgumentException(
                    "Las existencias no pueden ser negativas");
        }

        this.id = id;
        this.cdId = cdId;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void actualizarExistencias(int nuevaCantidad) {

        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException(
                    "Las existencias no pueden ser negativas");
        }

        this.cantidadDisponible = nuevaCantidad;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public UUID getCdId() {
        return cdId;
    }
}
