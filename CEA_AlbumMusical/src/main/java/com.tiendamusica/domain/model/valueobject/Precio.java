package com.tiendamusica.domain.model.valueobject;

import java.math.BigDecimal;

public class Precio {

    private final BigDecimal valor;
    private final String moneda;

    public Precio(BigDecimal valor, String moneda) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser nulo ni negativo");
        }

        if (valor.scale() > 2) {
            throw new IllegalArgumentException(
                    "El precio no puede tener más de dos decimales");
        }

        if (moneda == null || !moneda.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException(
                    "La moneda debe tener un código válido de tres letras");
        }

        this.valor = valor;
        this.moneda = moneda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getMoneda() {
        return moneda;
    }
}