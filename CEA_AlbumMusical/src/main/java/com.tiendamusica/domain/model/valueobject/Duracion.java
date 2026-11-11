package com.tiendamusica.domain.model.valueobject;

public class Duracion {

    private final int segundos;

    public Duracion(int segundos) {

        if (segundos <= 0) {
            throw new IllegalArgumentException(
                    "La duración debe ser mayor que cero");
        }

        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return segundos / 60;
    }

    public int getSegundosRestantes() {
        return segundos % 60;
    }
}