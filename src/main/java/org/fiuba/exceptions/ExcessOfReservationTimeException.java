package org.fiuba.exceptions;

public class ExcessOfReservationTimeException extends RuntimeException {

    public ExcessOfReservationTimeException(String message) {
        super(message);
    }
}
