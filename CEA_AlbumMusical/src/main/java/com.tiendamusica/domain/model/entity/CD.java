package com.tiendamusica.domain.model.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class CD {

    private final UUID id;
    private String codigoBarras;
    private String formato;
    private BigDecimal precio;
    private UUID edicionId;

    public CD(UUID id, String codigoBarras, String formato,
              BigDecimal precio, UUID edicionId) {

        if (id == null || edicionId == null) {
            throw new IllegalArgumentException("Los identificadores son obligatorios");
        }

        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException("El código de barras es obligatorio");
        }

        if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.id = id;
        this.codigoBarras = codigoBarras;
        this.formato = formato;
        this.precio = precio;
        this.edicionId = edicionId;
    }
}