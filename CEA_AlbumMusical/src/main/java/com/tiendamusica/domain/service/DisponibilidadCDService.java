package com.tiendamusica.domain.service;

import com.tiendamusica.domain.model.entity.CD;
import com.tiendamusica.domain.model.aggregate.Inventario;
import com.tiendamusica.domain.model.valueobject.Cantidad;
import com.tiendamusica.domain.exception.InventoryMismatchException;
import com.tiendamusica.domain.specification.ProductoDisponibleSpecification;

public class DisponibilidadCDService {

    public boolean verificarDisponibilidad(
            CD cd,
            Inventario inventario,
            Cantidad cantidadSolicitada) {

        if (cd == null || inventario == null) {
            throw new IllegalArgumentException(
                    "El CD y el inventario son obligatorios");
        }

        if (!cd.getId().equals(inventario.getCdId())) {
            throw new InventoryMismatchException(
                    "El inventario no corresponde al CD indicado");
        }

        ProductoDisponibleSpecification especificacion =
                new ProductoDisponibleSpecification(cantidadSolicitada);

        return especificacion.isSatisfiedBy(inventario);
    }
}