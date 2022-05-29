package org.fiuba.exceptions;

public class AlreadyReservedHourException extends RuntimeException {

    public AlreadyReservedHourException(String message) {
        super(message);
    }
}