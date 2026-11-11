package com.tiendamusica.domain.model.valueobject;

public class NumeroCatalogo {

    private final String valor;

    public NumeroCatalogo(String valor) {

        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    "El número de catálogo es obligatorio");
        }

        this.valor = valor.trim();
    }

    public String getValor() {
        return valor;
    }
}
