package com.tiendamusica.domain.model.aggregate;

import com.tiendamusica.domain.model.valueobject.Cantidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class Inventario {

    private final UUID id;
    private final UUID cdId;
    private Cantidad cantidadDisponible;
    private LocalDateTime fechaActualizacion;

    public Inventario(
            UUID id,
            UUID cdId,
            Cantidad cantidadDisponible) {

        if (id == null || cdId == null) {
            throw new IllegalArgumentException(
                    "Los identificadores son obligatorios");
        }

        if (cantidadDisponible == null) {
            throw new IllegalArgumentException(
                    "La cantidad es obligatoria");
        }

        this.id = id;
        this.cdId = cdId;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaActualizacion = LocalDateTime.now();
    }

    // Actualiza las existencias actuales
    public void actualizarExistencias(Cantidad nuevaCantidad) {

        if (nuevaCantidad == null) {
            throw new IllegalArgumentException(
                    "La nueva cantidad no puede ser nula");
        }

        this.cantidadDisponible = nuevaCantidad;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public UUID getCdId() {
        return cdId;
    }

    public Cantidad getCantidadDisponible() {
        return cantidadDisponible;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}