package com.tiendamusica.application.port.in;

import java.util.UUID;

public interface ActualizarExistenciasUseCase {

    void actualizarExistencias(UUID cdId, int nuevaCantidad);

}
