package com.tiendamusica.application.port.in;

import java.util.UUID;

public interface RegistrarObraMusicalUseCase {

    UUID registrar(RegistrarObraMusicalCommand comando);

}
