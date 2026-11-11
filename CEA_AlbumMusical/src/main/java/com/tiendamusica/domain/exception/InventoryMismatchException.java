package com.tiendamusica.domain.exception;

public class InventoryMismatchException extends DomainException {

    public InventoryMismatchException(String message) {
        super(message);
    }
}