package com.tiendamusica.domain.model.valueobject;

import java.time.Year;

public class AnioPublicacion {

    private final int valor;

    public AnioPublicacion(int valor) {

        int anioActual = Year.now().getValue();

        if (valor <= 0 || valor > anioActual) {
            throw new IllegalArgumentException(
                    "El año de publicación no es válido");
        }

        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}