package com.tiendamusica.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class ObraMusicalRegistrada implements DomainEvent {

    private final UUID obraId;
    private final String titulo;
    private final LocalDateTime fechaOcurrencia;

    public ObraMusicalRegistrada(UUID obraId, String titulo) {

        if (obraId == null) {
            throw new IllegalArgumentException(
                    "El identificador de la obra es obligatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException(
                    "El título de la obra es obligatorio");
        }

        this.obraId = obraId;
        this.titulo = titulo;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public UUID getObraId() {
        return obraId;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public LocalDateTime getFechaOcurrencia() {
        return fechaOcurrencia;
    }
}