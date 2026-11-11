package com.tiendamusica.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class ExistenciasActualizadas implements DomainEvent {

    private final UUID inventarioId;
    private final UUID cdId;
    private final int cantidadAnterior;
    private final int cantidadNueva;
    private final LocalDateTime fechaOcurrencia;

    public ExistenciasActualizadas(
            UUID inventarioId,
            UUID cdId,
            int cantidadAnterior,
            int cantidadNueva) {

        if (inventarioId == null || cdId == null) {
            throw new IllegalArgumentException(
                    "Los identificadores son obligatorios");
        }

        if (cantidadAnterior < 0 || cantidadNueva < 0) {
            throw new IllegalArgumentException(
                    "Las cantidades no pueden ser negativas");
        }

        this.inventarioId = inventarioId;
        this.cdId = cdId;
        this.cantidadAnterior = cantidadAnterior;
        this.cantidadNueva = cantidadNueva;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public UUID getInventarioId() {
        return inventarioId;
    }

    public UUID getCdId() {
        return cdId;
    }

    public int getCantidadAnterior() {
        return cantidadAnterior;
    }

    public int getCantidadNueva() {
        return cantidadNueva;
    }

    @Override
    public LocalDateTime getFechaOcurrencia() {
        return fechaOcurrencia;
    }
}
