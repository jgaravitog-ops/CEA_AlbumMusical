package com.tiendamusica.domain.model.valueobject;

import com.tiendamusica.domain.exception.InvalidQuantityException;

public class Cantidad {

    private final int valor;

    public Cantidad(int valor) {

        if (valor < 0) {
            throw new InvalidQuantityException(
            "La cantidad no puede ser negativa");
        }

        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
