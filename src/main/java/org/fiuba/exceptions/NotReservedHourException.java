package org.fiuba.exceptions;

public class NotReservedHourException extends RuntimeException {

    public NotReservedHourException(String message) {
        super(message);
    }
}
