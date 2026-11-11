package com.tiendamusica.domain.service;

import com.tiendamusica.domain.model.entity.CD;
import com.tiendamusica.domain.model.aggregate.Inventario;
import com.tiendamusica.domain.model.valueobject.Cantidad;

public class DisponibilidadCDService {

    public boolean verificarDisponibilidad(
            CD cd,
            Inventario inventario,
            Cantidad cantidadSolicitada) {

        if (cd == null || inventario == null ||
                cantidadSolicitada == null) {

            throw new IllegalArgumentException(
                    "Los datos del CD, inventario y cantidad son obligatorios");
        }

        if (!cd.getId().equals(inventario.getCdId())) {
            throw new IllegalArgumentException(
                    "El inventario no corresponde al CD indicado");
        }

        return inventario.getCantidadDisponible().getValor()
                >= cantidadSolicitada.getValor();
    }
}