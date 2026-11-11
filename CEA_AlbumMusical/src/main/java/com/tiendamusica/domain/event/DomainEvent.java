package com.tiendamusica.domain.event;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime getFechaOcurrencia();
}
