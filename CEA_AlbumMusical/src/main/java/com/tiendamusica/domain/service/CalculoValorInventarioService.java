package com.tiendamusica.domain.service;

import com.tiendamusica.domain.model.entity.CD;
import com.tiendamusica.domain.model.aggregate.Inventario;
import com.tiendamusica.domain.exception.InventoryMismatchException;

import java.math.BigDecimal;

public class CalculoValorInventarioService {

    public BigDecimal calcularValor(CD cd, Inventario inventario) {

        if (cd == null || inventario == null) {
            throw new IllegalArgumentException(
                    "El CD y el inventario son obligatorios");
        }

        if (!cd.getId().equals(inventario.getCdId())) {
            throw new InventoryMismatchException(
            "El inventario no corresponde al CD indicado");
        }

        BigDecimal precioUnitario = cd.getPrecio().getValor();

        int cantidad = inventario
                .getCantidadDisponible()
                .getValor();

        return precioUnitario.multiply(
                BigDecimal.valueOf(cantidad));
    }
}