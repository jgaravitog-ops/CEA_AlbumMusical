package com.tiendamusica.domain.factory;

import com.tiendamusica.domain.model.aggregate.ObraMusical;
import com.tiendamusica.domain.model.valueobject.AnioPublicacion;

import java.util.UUID;

public class ObraMusicalFactory {

    public ObraMusical crear(
            String titulo,
            String genero,
            int anio,
            String descripcion) {

        AnioPublicacion anioPublicacion =
                new AnioPublicacion(anio);

        return new ObraMusical(
                UUID.randomUUID(),
                titulo,
                genero,
                anioPublicacion,
                descripcion
        );
    }
}