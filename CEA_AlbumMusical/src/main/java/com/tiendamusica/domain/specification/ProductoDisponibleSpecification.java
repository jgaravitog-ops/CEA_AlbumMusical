package com.tiendamusica.domain.specification;

import com.tiendamusica.domain.model.aggregate.Inventario;
import com.tiendamusica.domain.model.valueobject.Cantidad;

public class ProductoDisponibleSpecification
        implements Specification<Inventario> {

    private final Cantidad cantidadRequerida;

    public ProductoDisponibleSpecification(
            Cantidad cantidadRequerida) {

        if (cantidadRequerida == null ||
                cantidadRequerida.getValor() <= 0) {

            throw new IllegalArgumentException(
                    "La cantidad solicitada debe ser mayor que cero");
        }

        this.cantidadRequerida = cantidadRequerida;
    }

    @Override
    public boolean isSatisfiedBy(Inventario inventario) {

        if (inventario == null) {
            return false;
        }

        return inventario.getCantidadDisponible().getValor()
                >= cantidadRequerida.getValor();
    }
}