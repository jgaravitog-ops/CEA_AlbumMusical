package com.tiendamusica.domain.model.entity;

import com.tiendamusica.domain.model.valueobject.Precio;
import java.util.UUID;

public class CD {

    private final UUID id;
    private final String codigoBarras;
    private final String formato;
    private final Precio precio;
    private final UUID edicionId;

    public CD(UUID id, String codigoBarras, String formato,
              Precio precio, UUID edicionId) {

        if (id == null || edicionId == null) {
            throw new IllegalArgumentException(
                    "Los identificadores son obligatorios");
        }

        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException(
                    "El código de barras es obligatorio");
        }

        if (precio == null) {
            throw new IllegalArgumentException(
                    "El precio es obligatorio");
        }

        this.id = id;
        this.codigoBarras = codigoBarras;
        this.formato = formato;
        this.precio = precio;
        this.edicionId = edicionId;
    }

    public UUID getId() {
        return id;
    }

    public Precio getPrecio() {
        return precio;
    }
}