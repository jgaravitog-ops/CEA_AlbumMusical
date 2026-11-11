package com.tiendamusica.domain.model.valueobject;

public class CodigoBarras {

    private final String valor;

    public CodigoBarras(String valor) {

        if (valor == null ||
                !valor.matches("[0-9]{8}|[0-9]{12}|[0-9]{13}|[0-9]{14}")) {

            throw new IllegalArgumentException(
                    "El código de barras debe contener 8, 12, 13 o 14 dígitos");
        }

        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}